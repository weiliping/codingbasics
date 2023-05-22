# 设计原则
   * 单一职责原则
        - SRP: Single Responsibility Principle
        - 一个类或者模块只负责完成一个职责（或者功能）
   * 开闭原则
        - OCP: Open Closed Principle
        - 对扩展开放、修改关闭。添加一个新的功能应该是，在已有代码基础上扩展代码（新增模块、类、方法等），而非修改已有代码（修改模块、类、方法等）
   * 里式替换原则
        - LSP: Liskov Substitution Principle
        - 最核心的就是理解“design by contract，按照协议来设计”
        - 子类的设计要保证在替换父类的时候，不改变原有程序的逻辑及不破坏原有程序的正确性。
   * 接口隔离原则
        - ISP: Interface Segregation Principle
        - 接口的设计要尽量单一，不要让接口的实现类和调用者，依赖不需要的接口函数。
   * 依赖反转原则
        - DIP: Dependency Inversion Principle
        - 高层模块（high-level modules）不要依赖低层模块（low-level）。高层模块和低层模块应该通过抽象（abstractions）来互相依赖。除此之外，抽象（abstractions）不要依赖具体实现细节（details），具体实现细节（details）依赖抽象（abstractions）。
   * KISS 原则
        - Keep It Simple and Stupid
        - 不要使用同事可能不懂的技术来实现代码
        - 不要重复造轮子，要善于使用已经有的工具类库
        - 不要过度优化
   * YAGNI 原则
        - You Ain’t Gonna Need It
        - 不要去设计当前用不到的功能；不要去编写当前用不到的代码。实际上，这条原则的核心思想就是：不要做过度设计
# 设计模式
   * 创建
        * 单例 [Singleton](./creation/singleton.md)
            - 概念
                - 一个类只允许创建一个对象（或者实例），那这个类就是一个单例类
            - 使用场景
                - 处理资源访问冲突
                - 表示全局唯一类
            - 单例的实现
                - 需要关注以下4点
                    - 构造函数需要是 private 访问权限的，这样才能避免外部通过 new 创建实例；
                    - 考虑对象创建时的线程安全问题；
                    - 考虑是否支持延迟加载；
                    - 考虑 getInstance() 性能是否高（是否加锁）。
                - 饿汉式
                   
                   在类加载的期间，就已经将 instance 静态实例初始化好了，所以，instance 实例的创建是线程安全的。不过，这样的实现方式不支持延迟加载实例。
                   ```java
                  public class EagerInitializedSingleton {
                      private static final EagerInitializedSingleton instance = new EagerInitializedSingleton();
                  
                      //private constructor to avoid client applications to use constructor
                      private EagerInitializedSingleton() {
                      }
                  
                      public static EagerInitializedSingleton getInstance() {
                          return instance;
                      }
                  }
                   ```
                - 懒汉式
                    
                   懒汉式相对于饿汉式的优势是支持延迟加载。这种实现方式会导致频繁加锁、释放锁，以及并发度低等问题，频繁的调用会产生性能瓶颈。
                   ```java
                   public class LazyInitializedSingleton {
                       private static LazyInitializedSingleton instance;
                   
                       private LazyInitializedSingleton() {
                       }
                   
                       public static LazyInitializedSingleton getInstance() {
                           if (instance == null) {
                               instance = new LazyInitializedSingleton();
                           }
                           return instance;
                       }
                   }
                   ``` 
                - 双重检测
                   
                  双重检测实现方式既支持延迟加载、又支持高并发的单例实现方式。只要 instance 被创建之后，再调用 getInstance() 函数都不会进入到加锁逻辑中。所以，这种实现方式解决了懒汉式并发度低的问题。
                  ```java
                  public class DoubleCheckingSingleton {
                      private static DoubleCheckingSingleton instance;
                  
                      private DoubleCheckingSingleton() {
                      }
                  
                      public static synchronized DoubleCheckingSingleton getInstance() {
                          if (instance == null) {
                              synchronized (DoubleCheckingSingleton.class) {
                                  if (instance == null) {
                                      instance = new DoubleCheckingSingleton();
                                  }
                              }
                          }
                          return instance;
                      }
                  }
                  ```
                - 静态内部类
                  
                  利用 Java 的静态内部类来实现单例。这种实现方式，既支持延迟加载，也支持高并发，实现起来也比双重检测简单。
                  ```java
                  public class InnerClassSingleton {
                      private InnerClassSingleton() {
                      }
                  
                      private static class SingletonHelper {
                          private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
                      }
                  
                      public static InnerClassSingleton getInstance() {
                          return SingletonHelper.INSTANCE;
                      }
                  }
                  ```
                - 枚举
                  
                  最简单的实现方式，基于枚举类型的单例实现。这种实现方式通过 Java 枚举类型本身的特性，保证了实例创建的线程安全性和实例的唯一性。
                  
                  ```java
                  public enum EnumSingleton {
                      INSTANCE;
                  
                      public static void doSomething() {
                          //do something
                      }
                  }
                  ```
        * 简单工厂 [Simple Factory](./creation/simple_factory.md)
        * 工厂方法 [Factory Method](./creation/factory_method.md)
        * 抽象工厂 [Abstract Factory](./creation/abstract_factory.md)
        * 建造者 [Builder](./creation/builder.md)
        * 原型 [Prototype](./creation/prototype.md)

   * 行为
        * 责任链 [Chain of Responsibility](./behavior/responsibility_chain.md)
        * 命令 [Command](./behavior/command.md)
        * 解释器 [Interpreter](./behavior/interpreter.md)
        * 迭代器 [Iterator](./behavior/iterator.md)
        * 中介者 [Mediator](./behavior/mediator.md)
        * 备忘录 [Memento](./behavior/memento.md)
        * 观察者 [Observer](./behavior/observer.md)
        * 状态 [State](./behavior/state.md)
        * 策略 [Strategy](./behavior/strategy.md)
        * 模版方法 [Template](./behavior/template_method.md)
        * 访问者 [Visitor](./behavior/visitor.md)
        * 空对象 [Null](./behavior/null.md)

   * 结构  
        * 适配器 [Adapter](./structure/adapter.md)
        * 桥接 [Bridge](./structure/bridge.md)
        * 组合 [Composite](./structure/composite.md)
        * 装饰 [Decorator](./structure/decorator.md)
        * 外观 [Facade](./structure/facade.md)
        * 享元 [Flyweight](./structure/flyweight.md)
        * 代理 [Proxy](./structure/proxy.md)
        
# Reference
   * [Design Pattern Tutorials](https://www.journaldev.com/java/design-patterns)