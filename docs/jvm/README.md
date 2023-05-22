# JAVA内存区域 [JVM memory](JVM_MEMORY.md)
   ### 运行时数据区域
   - **程序计数器（Program Counter Register）**
   - **Java虚拟机栈（Java Virtual Machine Stacks）**
   - **本地方法栈（Native Method Stack）**
   - **Java堆（Heap）**
   - **方法区（Method Area）**
   ### HotSpot中的对象
   - 对象的创建
   - 对象是如何创建的
     - 类加载检查
     - 分配内存
     - 初始化
     - 设置对象头
     - 执行方法
   - 对象的内存布局
   - 对象的访问定位
         
# GC算法与内存分配策略 [GC algorithm](GC_README.md) 
   ### 对象存活判定算法
   - 引用计数算法
   - 可达性分析算法
     
     GC Roots的对象包括以下几种:
     
     - 虚拟机栈（栈帧中的局部变量表，Local Variable Table）中引用的对象
     - 方法区中类静态属性引用的对象
     - 方法区中常量引用的对象
     - 本地方法栈中JNI（即一般说的Native方法）引用的对象
     
     **两次标记与 finalize()方法**
       - 当对象没有覆盖finaliza()方法
       - finaliza()方法已经被虚拟机调用过
   ### 垃圾收集算法
   - 标记－清除（Mark-Sweep）算法
     
     首先标记出所有需要回收的对象，在标记完成后统一回收所有被标记的对象。
   - 复制（Copying）算法
     
     将可用内存按容量分成大小相等的两块，每次只使用其中的一块。当这一块内存用完，就将还存活着的对象复制到另一块上面，然后再把已使用过的内存空间一次清理掉。
   - 标记－整理（Mark-Compact）算法
     
     让所有存活的对象都向一端移动，然后直接清理掉边界以外的内存。
   - 分代收集（Generational Collection）算法
   
     根据对象存活周期的不同将内存划分为几块，一般是把Java堆分为新生代和老年代，这样就可以根据各个年代的特点采用最适合的收集算法：
     - 新生代 - **复制算法**
     - 老年代 - **标记-清除或标记-整理**  
   ### HotSpot的算法实现
   - 枚举根节点
     - **GC停顿（”Stop The World”）**
     - **准确式GC与OopMap(Ordinary Object Pointer)**
   - 安全点（Safepoint）- 进行GC时程序停顿的位置
   - 安全区域（Safe Region）
 
   ### 内存分配策略
   - 对象优先在Eden区分配
   - 大对象直接进入老年代
   - 长期存活的对象进入老年代
   - 动态对象年龄判定
   - 空间分配担保 
   
   ### Full GC的触发条件 
   - 调用System.gc()
   - 老年代空间不足
   - 空间分配担保失败
   - JDK 1.7及以前的永久代空间不足
   - Concurrent Mode Failure

# 垃圾收集器 [Garbage collectors](GARBAGE_COLLECTORS.md)
   | 收集器 | 串行、并行or并发 | 新生代/老年代 | 算法 | 目标 | 适用场景 |
   | --- | --- | --- | --- | --- | --- |
   |Serial|	串行	|新生代	|复制算法	|响应速度优先	|单CPU环境下的Client模式|
   |Serial Old	|串行	|老年代	|标记-整理	|响应速度优先	|单CPU环境下的Client模式、CMS的后备预案|
   |ParNew	|并行	|新生代	|复制算法	|响应速度优先	|多CPU环境时在Server模式下与CMS配合|
   |Parallel Scavenge	|并行	|新生代	|复制算法	|吞吐量优先	|在后台运算而不需要太多交互的任务|
   |Parallel Old	|并行	|老年代	|标记-整理	|吞吐量优先	|在后台运算而不需要太多交互的任务|
   |CMS	|并发	|老年代	|标记-清除	|响应速度优先	|集中在互联网站或B/S系统服务端上的Java应用|
   |G1	|并发	|both	|标记-整理+复制算法	|响应速度优先	|面向服务端应用，将来替换CMS|  

# JVM 类加载 [Java class loading, linking, and initialization](JVM_CLASS_LOADING.md)
   ### 类加载过程
   - **加载（Loading）**
   - **连接（Linking）**
     - **验证（Verification）**
     - **准备（Preparation）**
     - **解析（Resolution）**
   - **初始化（Initialization）**
   - 使用（Using）
   - 卸载（Unloading）
   
   ### 类初始化的时机
   - **主动引用**
     - 遇到new、getstatic、putstatic、invokestatic这四条字节码指令时
     
     - 使用 java.lang.reflect包的方法对类进行反射调用的时
     
     - 当初始化一个类的时候，如果发现其父类还没有进行过初始化，则需要先触发其父类的初始化
     
     - 当虚拟机启动时，用户需要制定一个要执行的主类（包含main方法的那个类），虚拟机会先初始化这个主类
     
     - 当使用jdk1.7 的动态语言支持时，如果一个java.lang.invoke.MethodHandle实例最后的解析结果REF_getStatic, REF_putStatic, REF_invokeStatic 的方法句柄，并且这个方法句柄所对应的类没有进行过初始化，则需要先触发其初始化
   
   - **被动引用**
     
     - 通过子类引用父类的静态字段，不会导致子类初始化
     
     - 通过数组定义来引用类，不会触发此类的初始化，如SuperClass[] sca = new SuperClass[10];
     
     - 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
   
   ### 类加载过程详解  
   - **加载**
     
     - 通过一个类的全限定名来获取定义此类的二进制字节流。
     - 将这个字节流所代表的静态存储结构转化为方法区的运行时存储结构。
     - 在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口。
         
   - **验证**
     - 文件格式验证
     - 元数据验证
     - 字节码验证
     - 符号引用验证
   - **准备**
     
     准备阶段的主要任务是如下两点：
     - **为类变量分配内存**
     - **设置类变量初始值**
   - **解析**
     
     解析阶段是虚拟机将常量池内的符号引用替换为直接引用的过程。
   - **初始化**
     
     **初始化阶段即虚拟机执行类构造器\<clinit>()方法的过程。**
     在准备阶段，变量已经赋过一次系统要求的初始值，而在初始化阶段，根据程序员通过程序制定的主观计划去初始化类变量和其它资源。
   
   ### 类与类加载器
   
   对于任意一个类，都需要由加载它的类加载器和这个类本身一同确立其在Java虚拟机中的唯一性，每一个类加载器，都拥有一个独立的类名称空间。
   
   ### 双亲委派模型
   
   **从jvm的角度**
   - **启动类加载器（Bootstrap ClassLoader）**，这个类加载器用C++实现，是虚拟机自身的一部分；
   
   - **所有其他类的加载器**，这些类由Java实现，独立于虚拟机外部，并且全都继承自抽象类java.lang.ClassLoader。  

   **从Java开发人员的角度**
   - **启动类加载器（Bootstrap ClassLoader）**
   - **扩展类加载器（Extension ClassLoader）**
   - **应用程序类加载器（Application ClassLoader）**
   
   ### 破坏双亲委派模型
   
   - 线程上下文类加载器
   - 追求程序动态性
   
   ### 自定义类加载器
   - 采用双亲委派模型
   - 破坏双亲委派模型
   
   ### OSGi：类加载器的灵活运用
   
   OSGi（Open Service Gateway Initiative）是OSGi联盟制定的一个基于Java语言的动态模块化规范，现在成为了Java“事实上”的模块化标准。它为开发人员提供了面向服务和基于组件的运行环境，并提供标准的方式用来管理软件的生命周期。
   
# Reference
   - [《深入理解Java虚拟机——JVM高级特性与最佳实践》－周志明](https://book.douban.com/subject/24722612/)
   - JVM 解剖公园 [JVM anatomy quarks](https://shipilev.net/jvm/anatomy-quarks/)
   
# Return
 - [Coding Basics](../../README.md)
   