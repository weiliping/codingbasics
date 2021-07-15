# 线程安全
  - 什么是线程安全
    
    当多个线程访问某个类时，这个类始终都能表现出正确的行为。
    
    无状态对象一定是线程安全的。
  - 原子性
    - 竞态条件
    - 复合操作
  - 加锁机制
    - 内置锁
      - 同步代码块（synchronized Block）
      - 互斥锁
      - 可重入
  - 用锁来保护状态
    
    对于可能被多个线程同时访问的可变状态变量，在访问它时都需要持有同一个锁。
    
    每个共享的和可变的变量都应该只由一个锁来保护
    
    对于每个包含多个变量的不变性条件，其中涉及的所有变量都需要由同一锁来保护
    
  - 活跃性和性能
    
    当执行时间较长的计算或者可能无法快速完成的操作时（例如，网络I/O或者控制台I/O），一定不要持有锁。
  
# 对象共享
  - 可见性
    
    在没有同步的情况下，编译器、处理器以及运行时都可能对操作的执行顺序进行一些意想不到的调整。
    - 失效数据
    - 非原子的64位操作
      
      JVM允许将64位读或写操作分解位32位的操作。  
    - 加锁与可见性
    
      加锁的含义不仅仅是互斥，还包括内存可见性。
    - Volatile
      - 保证变量的可见性
        
        Java 内存模型下，线程可以把变量保存本地内存（比如机器的寄存器）中，而不是直接在主存中进行读写。这就可能造成一个线程在主存中修改了一个变量的值，而另外一个线程还继续使用它在寄存器中的变量值的拷贝，造成数据的不一致。
      - 防止指令重排序
        
        代码在执行的过程中的先后顺序，Java 在编译器以及运行期间的优化，代码的执行顺序未必就是编写代码时候的顺序。
        
        uniqueInstance = new Singleton(); 这段代码其实是分为三步执行：
        
        1. 为 uniqueInstance 分配内存空间
        2. 初始化 uniqueInstance
        3. 将 uniqueInstance 指向分配的内存地址
        
        由于 JVM 具有指令重排的特性，执行顺序有可能变成 1->3->2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。
        
    - 发布与逸出
      
      不要在构造过程中使用this引用逸出。
    - 线程封闭
      
      局部变量和ThreadLocal类
      - Ad-hoc 线程封闭
      - 栈封闭
      - ThreadLocal类
    - 不变性
    
      不可变对象一定是线程安全的。
    - 安全发布
# 对象的组合
  
  - 设计线程安全的类
    
    - 收集同步需求
    - 依赖状态的操作
    - 状态的所有权
  
  - 实例封闭 
    - Java监视器模式
  - 线程安全性的委托
    - 独立的状态变量
    - 当委托失效时
    - 发布底层的状态变量
  - 在现有的线程安全类中添加功能
    - 客户端加锁机制
    - 组合
  - 将同步策略文档化 
  
# 基础构建模块
  - 同步容器类
    - Vector
    - HashTable
  - 并发容器
    - ConcurrentLinkedQueue
    - ConcurrentHashMap
    - ConcurrentSkipListMap
    - ConcurrentSkipListSet
    - CopyOnWriteArrayList
  - 阻塞队列和生产者 - 消费者模式
  - 阻塞方法和中断方法
    - 传递InterruptedException
    - 恢复中断
  - 同步工具类
  - 构建高效且可伸缩的结果缓存
  
# 任务执行
  - 在线程中执行任务
    - 串行地执行任务
    - 显式地为任务创建线程
    - 无限制创建线程的不足
      - 线程生命周期的开销非常高
      - 资源消耗
      - 稳定性
  - Executor框架
    - 执行策略
    - 线程池
      
      指管理一组同构工作线程的资源池。
      - newFixedThreadPool
      - newCachedThreadPool
      - newSingleThreadExecutor
      - newScheduledThreadPool
    - Executor生命周期
    - 延迟任务与周期任务   
  - 找出可利用的并行性

# 取消与关闭

  - 任务取消
    
    取消某个操作的原因： 1. 用户请求取消, 2. 有时间限制的操作, 3. 应用程序事件, 4. 错误, 5. 关闭
    - 中断
    - 中断策略
    - 响应中断
    - 通过Future来实现取消
    - 处理不可中断的阻塞
  - 停止基于线程的服务
    - 关闭ExecutorService
      - shutdown
      - shutdownNow
    - 毒丸 对象
    - shutdownNow的局限性
  - 处理非正常的线程终止
  - JVM 关闭
  
# 线程池的使用
  - 在任务与执行策略之间的隐形耦合
    - 依赖性任务
    - 使用线性封闭机制的任务
    - 对响应时间敏感的任务
    - 使用ThreadLocal的任务
  - 设置线程池的大小
  - 配置 ThreadPoolExecutor
  - 扩展ThreadPoolExecutor
  - 递归算法的并行化

# 显式锁
  - Lock与ReentrantLock
    - 轮询锁与定时锁
    - 可中断的锁获取操作
    - 非块结构的加锁
  - 性能考虑因素
  - 公平性
  - 在内置锁（synchronized)和ReentrantLock之间进行选择
  - 读 写锁
    
          
       
# 并发 - 多线程
   * Synchronized - implemented by JVM
        * Monitor.entry
        * Monitor.exit
        * Synchronize Object
            ```java
            public class SynchronizedExample {          
                public void func1() {
                    synchronized (this) {
                        for (int i = 0; i < 10; i++) {
                            System.out.print(i + " ");
                        }
                    }
                }
            }  
            ```
            ```java
            public class SynchronizedExample {
                public synchronized void func () {
                    // ...
                }
            }
            ```
        * Synchronize Class
            ```java
            public class SynchronizedExample {
                public void func() {
                    synchronized (SynchronizedExample.class) {
                        // ...
                    }
                }
            }
            ```
            ```java
            public class SynchronizedExample {
                public synchronized static void fun() {
                    // ...
                }
            }
            ```
   * Volatile
   * Compare and Swap(CAS)
   * Abstract Queued Synchronizer(AQS)
   * ReentrantLock - implemented by JDK
   * ReentrantReadWriteLock
   * CountDownLatch
   * ConcurrentHashMap
        * ReentrantLock + Segment + HashEntry - JDK 1.7
        * Synchronized + CAS + HashEntry + Red–black Tree - JDK 1.8
