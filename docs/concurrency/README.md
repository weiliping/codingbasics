# 使用线程

  有三种使用线程的方法：
  
  - 实现Runnable接口
  - 实现Callable接口
  - 继承Thread类
  
  实现 Runnable 和 Callable 接口的类只能当做一个可以在线程中运行的任务，不是真正意义上的线程，因此最后还需要通过 Thread 来调用。可以理解为任务是通过线程驱动从而执行的。
  
  ### 实现Runnable接口
      
   需要实现接口中的 run() 方法
   
   ```
   public class MyRunnable implements Runnable {
       @Override
       public void run() {
           // todo...
           System.out.println("MyRunnable");
       }
   }
   ```
   
   使用 Runnable 实例再创建一个 Thread 实例，然后调用 Thread 实例的 start() 方法来启动线程。
  
  ### 实现Callable接口 
   
   与 Runnable 相比，Callable 可以有返回值，返回值通过 FutureTask 进行封装
   
   ```
   public class MyCallable implements Callable<Integer> {
       public Integer call() {
           return 123;
       }
   }
   ```
   ```
   public static void main(String[] args) throws ExecutionException, InterruptedException {
       MyCallable mc = new MyCallable();
       FutureTask<Integer> ft = new FutureTask<>(mc);
       Thread thread = new Thread(ft);
       thread.start();
       System.out.println(ft.get());
   }
   ```
  ### 继承Thread类
  同样也是需要实现 run() 方法，因为 Thread 类也实现了Runnable接口。
  
  当调用 start() 方法启动一个线程时，虚拟机会将该线程放入就绪队列中等待被调度，当一个线程被调度时会执行该线程的 run() 方法。
  
  ```
  public class MyThread extends Thread {
      public void run() {
          // ...
      }
  }
  ```
  ```
  public static void main(String[] args) {
      MyThread mt = new MyThread();
      mt.start();
  }
  ```
  
  ### 实现接口 VS 继承Thread
  实现接口会更好一些，因为：
  - Java 不支持多重继承，因此继承了 Thread 类就无法继承其它类，但是可以实现多个接口
  - 类可能只要求可执行就行，继承整个 Thread 类开销过大
  
 # 基础线程机制
  
  ### Executor
    
   Executor 管理多个异步任务的执行，而无需程序员显式地管理线程的生命周期。这里的异步是指多个任务的执行互不干扰，不需要进行同步操作。
   主要有三种 Executor：
   - CachedThreadPool：一个任务创建一个线程；
   - FixedThreadPool：所有任务只能使用固定大小的线程
   - SingleThreadExecutor：相当于大小为 1 的 FixedThreadPool
  ### Daemon [Java Sample](../../src/main/java/com/concurrency/DaemonThreadTest.java)
   
   守护线程是程序运行时在后台提供服务的线程，不属于程序中不可或缺的部分。
   当所有非守护线程结束时，程序也就终止，同时会杀死所有守护线程。
   main() 属于非守护线程。
   在线程启动之前使用 setDaemon() 方法可以将一个线程设置为守护线程。
   
  ### sleep()
   
   Thread.sleep(millisec) 方法会休眠当前正在执行的线程，millisec 单位为毫秒。
   sleep() 可能会抛出 InterruptedException，因为异常不能跨线程传播回 main() 中，因此必须在本地进行处理。线程中抛出的其它异常也同样需要在本地进行处理。   
   
   ```
   public void run() {
       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
   }
   ```
  ### yield()
  
   对静态方法 Thread.yield() 的调用声明了当前线程已经完成了生命周期中最重要的部分，可以切换给其它线程来执行。该方法只是对线程调度器的一个建议，而且也只是建议具有相同优先级的其它线程可以运行。
   ```
   public void run() {
       Thread.yield();
   }
   ```
# 线程池的创建
  ### Executor框架
  
  Executor是一套线程池管理框架，接口里只有一个方法execute，执行Runnable任务。ExecutorService接口扩展了Executor，添加了线程生命周期的管理，提供任务终止、返回任务结果等方法。AbstractExecutorService实现了ExecutorService，提供例如submit方法的默认实现逻辑。
  
  ### 构造方法
  ```
  public ThreadPoolExecutor(int corePoolSize,
                                int maximumPoolSize,
                                long keepAliveTime,
                                TimeUnit unit,
                                BlockingQueue<Runnable> workQueue,
                                ThreadFactory threadFactory,
                                RejectedExecutionHandler handler) {
  }
  ```
  corePoolSize是线程池的目标大小，也叫核心线程数。maximumPoolSize是线程池的最大上限，maximumPoolSize减去corePoolSize即是非核心线程数，或者叫空闲线程。keepAliveTime指明空闲线程的存活时间，超出存活时间的空闲线程就会被回收
  
  ### 预设的定制线程池
  ThreadPoolExecutor预设了一些已经定制好的线程池，由Executors里的工厂方法创建。下面分析newSingleThreadExecutor、newFixedThreadPool、newCachedThreadPool的创建参数。
  
  - newFixedThreadPool
    
    newFixedThreadPool的corePoolSize和maximumPoolSize都设置为传入的固定数量，keepAliveTim设置为0。线程池创建后，线程数量将会固定不变，适合需要线程很稳定的场合。
    
  - newSingleThreadExecutor
    
    newSingleThreadExecutor是线程数量固定为1的newFixedThreadPool版本，保证池内的任务串行。
    
  - newCachedThreadPool
    
    newCachedThreadPool生成一个会缓存的线程池，线程数量可以从0到Integer.MAX_VALUE，超时时间为1分钟。线程池用起来的效果是：如果有空闲线程，会复用线程；如果没有空闲线程，会新建线程；如果线程空闲超过1分钟，将会被回收。
      
  - newScheduledThreadPool
  
    newScheduledThreadPool将会创建一个可定时执行任务的线程池。
    
  ### 等待队列

   newCachedThreadPool的线程上限几乎等同于无限，但系统资源是有限的，任务的处理速度总有可能比不上任务的提交速度。因此，可以为ThreadPoolExecutor提供一个阻塞队列来保存因线程不足而等待的Runnable任务，这就是BlockingQueue。
    
   JDK为BlockingQueue提供了几种实现方式，常用的有：
    
   - ArrayBlockingQueue：数组结构的阻塞队列
   - LinkedBlockingQueue：链表结构的阻塞队列
   - PriorityBlockingQueue：有优先级的阻塞队列
   - SynchronousQueue：不会存储元素的阻塞队列
   
   newFixedThreadPool和newSingleThreadExecutor在默认情况下使用一个无界的LinkedBlockingQueue。要注意的是，如果任务一直提交，但线程池又不能及时处理，等待队列将会无限制地加长，系统资源总会有消耗殆尽的一刻。所以，推荐使用有界的等待队列，避免资源耗尽。
   
   newCachedThreadPool使用的SynchronousQueue十分有趣，看名称是个队列，但它却不能存储元素。要将一个任务放进队列，必须有另一个线程去接收这个任务，一个进就有一个出，队列不会存储任何东西。因此，SynchronousQueue是一种移交机制，不能算是队列。newCachedThreadPool生成的是一个没有上限的线程池，理论上提交多少任务都可以，使用SynchronousQueue作为等待队列正合适。
   
   ### 饱和策略
   
   当有界的等待队列满了之后，就需要用到饱和策略去处理，ThreadPoolExecutor的饱和策略通过传入RejectedExecutionHandler来实现。如果没有为构造函数传入，将会使用默认的defaultHandler(AbortPolicy)。
   AbortPolicy是默认的实现，直接抛出一个RejectedExecutionException异常，让调用者自己处理。
   
   - DiscardPolicy的rejectedExecution直接是空方法，什么也不干。如果队列满了，后续的任务都抛弃掉。
   - DiscardOldestPolicy会将等待队列里最旧的任务踢走，让新任务得以执行。
   - CallerRunsPolicy，它既不抛弃新任务，也不抛弃旧任务，而是直接在当前线程运行这个任务。当前线程一般就是主线程啊，让主线程运行任务，说不定就阻塞了。
   
   ### ThreadFactory
   
   每当线程池需要创建一个新线程，都是通过线程工厂获取。如果不为ThreadPoolExecutor设定一个线程工厂，就会使用默认的defaultThreadFactory：
   
   ```
   public static ThreadFactory defaultThreadFactory() {
       return new DefaultThreadFactory();
   }
   ```
   
   ```
   static class DefaultThreadFactory implements ThreadFactory {
       private static final AtomicInteger poolNumber = new AtomicInteger(1);
       private final ThreadGroup group;
       private final AtomicInteger threadNumber = new AtomicInteger(1);
       private final String namePrefix;

       DefaultThreadFactory() {
           SecurityManager s = System.getSecurityManager();
           group = (s != null) ? s.getThreadGroup() :
                                Thread.currentThread().getThreadGroup();
           namePrefix = "pool-" +
                        poolNumber.getAndIncrement() +
                       "-thread-";
       }

       public Thread newThread(Runnable r) {
           Thread t = new Thread(group, r,
                                namePrefix + threadNumber.getAndIncrement(),
                                0);
           if (t.isDaemon())
               t.setDaemon(false);
           if (t.getPriority() != Thread.NORM_PRIORITY)
               t.setPriority(Thread.NORM_PRIORITY);
           return t;
       }
   }
   ```
   
   这个默认的线程工厂，创建的线程是普通的非守护线程，如果需要定制，实现ThreadFactory后传给ThreadPoolExecutor即可。
     
# 中断
  Java提供了中断机制，Thread类下有三个重要方法。
  
  - public void interrupt()
  - public boolean isInterrupted()
  - public static boolean interrupted(); // 清除中断标志，并返回原状态
  
  ### InterruptedException
  通过调用一个线程的 interrupt() 来中断该线程，如果该线程处于阻塞、限期等待或者无限期等待状态，那么就会抛出 InterruptedException，从而提前结束该线程。但是不能中断 I/O 阻塞和 synchronized 锁阻塞。
  
  对于以下代码，在 main() 中启动一个线程之后再中断它，由于线程中调用了 Thread.sleep() 方法，因此会抛出一个 InterruptedException，从而提前结束线程，不执行之后的语句。
  
  ```java
  public class InterruptExample {
      private static class MyThread1 extends Thread {
          @Override
          public void run() {
              try {
                  System.out.println("Thread start to sleep");
                  Thread.sleep(2000);
                  System.out.println("Thread run");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
      }
  
      public static void main(String[] args) throws InterruptedException {
          Thread thread1 = new MyThread1();
          thread1.start();
          thread1.interrupt();
          System.out.println("Main run");
      }
  }
  ```
  
  ```
  Thread start to sleep
  java.lang.InterruptedException: sleep interrupted
  Main run
  	at java.lang.Thread.sleep(Native Method)
  	at com.concurrency.InterruptExample$MyThread1.run(InterruptExample.java:9)
  
  ```
  ### interrupted()
  
  如果一个线程的 run() 方法执行一个无限循环，并且没有执行 sleep() 等会抛出 InterruptedException 的操作，那么调用线程的 interrupt() 方法就无法使线程提前结束。
  
  但是调用 interrupt() 方法会设置线程的中断标记，此时调用 interrupted() 方法会返回 true。因此可以在循环体中使用 interrupted() 方法来判断线程是否处于中断状态，从而提前结束线程。
  
  ```java
  public class InterruptExample {
      private static class MyThread2 extends Thread {
          @Override
          public void run() {
              System.out.println("MyThread2 start");
              while (!interrupted()) {
                  System.out.println("MyThread2 no interrupted");
              }
              System.out.println("Thread end");
          }
      }
          
      public static void main(String[] args) throws InterruptedException {
          Thread thread2 = new MyThread2();
          thread2.start();
          thread2.interrupt();
      }
  }
  ```
  
  ```
  MyThread2 start
  Thread end
  ```
  ### Executor 的中断操作
  
  调用 Executor 的 shutdown() 方法会等待线程都执行完毕之后再关闭，但是如果调用的是 shutdownNow() 方法，则相当于调用每个线程的 interrupt() 方法。
  
  以下使用 Lambda 创建线程，相当于创建了一个匿名内部线程。
  
  ```java
  public class InterruptExample {
      public static void main(String[] args) {
          ExecutorService executorService = Executors.newCachedThreadPool();
          executorService.execute(() -> {
              try {
                  Thread.sleep(2000);
                  System.out.println("Thread run");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          });
          executorService.shutdownNow();
          System.out.println("Main run");
      }
  }
  ```
  
  ```
  Main run
  java.lang.InterruptedException: sleep interrupted
      at java.lang.Thread.sleep(Native Method)
      at ExecutorInterruptExample.lambda$main$0(ExecutorInterruptExample.java:9)
      at ExecutorInterruptExample$$Lambda$1/1160460865.run(Unknown Source)
      at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
      at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
      at java.lang.Thread.run(Thread.java:745)
  ```
  
  如果只想中断 Executor 中的一个线程，可以通过使用 submit() 方法来提交一个线程，它会返回一个 Future<?> 对象，通过调用该对象的 cancel(true) 方法就可以中断线程。
  
  ```java
  public class InterruptByFuture {
  
      public static void main(String[] args) throws Exception {
          ExecutorService es = Executors.newSingleThreadExecutor();
          Future<?> task = es.submit(new MyThread());
  
          try {
              //限定时间获取结果
              task.get(5, TimeUnit.SECONDS);
          } catch (TimeoutException e) {
              //超时触发线程中止
              System.out.println("thread over time");
          } catch (ExecutionException e) {
              throw e;
          } finally {
              boolean mayInterruptIfRunning = true;
              task.cancel(mayInterruptIfRunning);
          }
      }
  
      private static class MyThread extends Thread {
  
          @Override
          public void run() {
              while (!Thread.currentThread().isInterrupted()) {   
                  try {
                      System.out.println("count");
                      Thread.sleep(1000);
                  } catch (InterruptedException e) {
                      System.out.println("interrupt");
                      Thread.currentThread().interrupt();
                  }
              }
              System.out.println("thread stop");
          }
  
          public void cancel() {
              interrupt();
          }
      }
  }
  ```
  
  Future的get方法可以传入时间，如果限定时间内没有得到结果，将会抛出TimeoutException。此时，可以调用Future的cancel()方法，对任务所在线程发出中断请求。
  cancel()有个参数mayInterruptIfRunning，表示任务是否能够接收到中断。
  
  - mayInterruptIfRunning=true时，任务如果在某个线程中运行，那么这个线程能够被中断；
  - mayInterruptIfRunning=false时，任务如果还未启动，就不要运行它，应用于不处理中断的任务
  
  要注意，mayInterruptIfRunning=true表示线程能接收中断，但线程是否实现了中断不得而知。线程要正确响应中断，才能真正被cancel。
  
# 互斥同步

  Java 提供了两种锁机制来控制多个线程对共享资源的互斥访问，第一个是 JVM 实现的 synchronized，而另一个是 JDK 实现的 ReentrantLock。
  
  # synchronized
  
   - 同步一个代码块
   ```
   public void func() {
       synchronized (this) {
           // ...
       }
   }
   ```
  它只作用于同一个对象，如果调用两个对象上的同步代码块，就不会进行同步。
  
  - 同步一个方法
  ```
  public synchronized void func () {
      // ...
  }
  ```
  它和同步代码块一样，作用于同一个对象。
  
  - 同步一个类
  
  ```
  public void func() {
      synchronized (SynchronizedExample.class) {
          // ...
      }
  }
  ```
  作用于整个类
  
  - 同步一个静态方法
  ```
  public synchronized static void fun() {
      // ...
  }
  ```
  ### ReentrantLock 
  
  ReentrantLock 是 java.util.concurrent（J.U.C）包中的锁。
  
  ```java
  public class LockExample {
  
      private Lock lock = new ReentrantLock();
  
      public void func() {
          lock.lock();
          try {
              for (int i = 0; i < 10; i++) {
                  System.out.print(i + " ");
              }
          } finally {
              lock.unlock(); // 确保释放锁，从而避免发生死锁。
          }
      }
  }
  ```
  ### 公平锁和非公平锁
    
  - 公平锁：线程获取锁的顺序和调用lock的顺序一样，FIFO；
  - 非公平锁：线程获取锁的顺序和调用lock的顺序无关，全凭运气。
    
  ### 比较
  
  - 锁的实现
  
    synchronized 是 JVM 实现的，而 ReentrantLock 是 JDK 实现的。
  
  - 性能
    
    新版本 Java 对 synchronized 进行了很多优化，例如自旋锁等，synchronized 与 ReentrantLock 大致相同。
  
  - 等待可中断
  
    当持有锁的线程长期不释放锁的时候，正在等待的线程可以选择放弃等待，改为处理其他事情。
    ReentrantLock 可中断，而 synchronized 不行。
    
  - 公平锁
   
    公平锁是指多个线程在等待同一个锁时，必须按照申请锁的时间顺序来依次获得锁。
    synchronized 中的锁是非公平的，ReentrantLock 默认情况下也是非公平的，但是也可以是公平的。
 
  - 锁绑定多个条件
    
    一个 ReentrantLock 可以同时绑定多个 Condition 对象。
    
  ### 使用选择
    
  除非需要使用 ReentrantLock 的高级功能，否则优先使用 synchronized。这是因为 synchronized 是 JVM 实现的一种锁机制，JVM 原生地支持它，而 ReentrantLock 不是所有的 JDK 版本都支持。并且使用 synchronized 不用担心没有释放锁而导致死锁问题，因为 JVM 会确保锁的释放。
  
# 线程间通信 [Reference](https://redspider.gitbook.io/concurrent/di-yi-pian-ji-chu-pian/5)
    
  - 锁机制
    - 互斥锁
    
      确保同一时间只能有一个线程访问共享资源。当锁被占用时试图对其加锁的线程都进入阻塞状态(释放CPU资源使其由运行状态进入等待状态)。当锁释放时哪个等待线程能获得该锁取决于内核的调度。
      
    - 读写锁
      
      当以写模式加锁而处于写状态时任何试图加锁的线程(不论是读或写)都阻塞，当以读状态模式加锁而处于读状态时“读”线程不阻塞，“写”线程阻塞。读模式共享，写模式互斥。
      
    - 条件变量
      
      可以以原子的方式阻塞进程，直到某个特定条件为真为止。对条件的测试是在互斥锁的保护下进行的。条件变量始终与互斥锁一起使用。
      
    - 自旋锁
    
      上锁受阻时线程不阻塞而是在循环中轮询查看能否获得该锁，没有线程的切换因而没有切换开销，不过对CPU的霸占会导致CPU资源的浪费。 所以自旋锁适用于并行结构(多个处理器)或者适用于锁被持有时间短而不希望在线程切换产生开销的情况。
  
  - 信号量机制(Semaphore)
    
    信号量实际上是一个非负的整数计数器，用来实现对公共资源的控制。在公共资源增加的时候，信号量就增加；公共资源减少的时候，信号量就减少；只有当信号量的值大于0的时候，才能访问信号量所代表的公共资源。
  
  - 管道
    
    使用管道多半与I/O流相关。当我们一个线程需要先另一个线程发送一个信息（比如字符串）或者文件等等时，就需要使用管道通信了
     
  - wait/notify（等待/通知）
    
    Java多线程的等待/通知机制是基于Object类的wait()方法和notify(), notifyAll()方法来实现的。
    一个锁同一时刻只能被一个线程持有。而假如线程A现在持有了一个锁lock并开始执行，它可以使用lock.wait()让自己进入等待状态。这个时候，lock这个锁是被释放了的。
    这时，线程B获得了lock这个锁并开始执行，它可以在某一时刻，使用lock.notify()，通知之前持有lock锁并进入等待状态的线程A，说“线程A你不用等了，可以往下执行了”。
    
  - 其它通信相关
    - join方法
    
      join()方法是Thread类的一个实例方法。它的作用是让当前线程陷入“等待”状态，等join的这个线程执行完成后，再继续执行当前线程。
    - sleep方法
      
      sleep方法是Thread类的一个静态方法。它的作用是让当前线程睡眠一段时间。
      
      sleep与wait的区别：
       - wait可以指定时间，也可以不指定；而sleep必须指定时间。
       - wait释放cpu资源，同时释放锁；sleep释放cpu资源，但是不释放锁，所以易死锁。
       - wait必须放在同步块或同步方法中，而sleep可以再任意位置
    - ThreadLocal类
      
      ThreadLocal类并不属于多线程间的通信，而是让每个线程有自己”独立“的变量，线程之间互不影响。它为每个线程都创建一个副本，每个线程可以访问自己内部的副本变量。
      
    - InheritableThreadLocal
      
      InheritableThreadLocal类与ThreadLocal类稍有不同，Inheritable是继承的意思。它不仅仅是当前线程可以存取副本值，而且它的子线程也可以存取这个副本值。
      
# 线程之间的协作
  
  当多个线程可以一起工作去解决某个问题时，如果某些部分必须在其它部分之前完成，那么就需要对线程进行协调。
  
  ### join()
  
  在线程中调用另一个线程的 join() 方法，会将当前线程挂起，而不是忙等待，直到目标线程结束。
  
  对于以下代码，虽然 b 线程先启动，但是因为在 b 线程中调用了 a 线程的 join() 方法，b 线程会等待 a 线程结束才继续执行，因此最后能够保证 a 线程的输出先于 b 线程的输出。
  
  ```java
  
  public class JoinExample {
  
      private class A extends Thread {
          @Override
          public void run() {
              System.out.println("A");
          }
      }
  
      private class B extends Thread {
  
          private A a;
  
          B(A a) {
              this.a = a;
          }
  
          @Override
          public void run() {
              try {
                  a.join();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.println("B");
          }
      }
  
      public void test() {
          A a = new A();
          B b = new B(a);
          b.start();
          a.start();
      }
  }
  ```
  ### wait() notify() notifyAll()
  
  调用 wait() 使得线程等待某个条件满足，线程在等待时会被挂起，当其他线程的运行使得这个条件满足时，其它线程会调用 notify() 或者 notifyAll() 来唤醒挂起的线程。
  
  它们都属于 Object 的一部分，而不属于 Thread。
  
  只能用在同步方法或者同步控制块中使用，否则会在运行时抛出 IllegalMonitorStateException。
  
  使用 wait() 挂起期间，线程会释放锁。这是因为，如果没有释放锁，那么其它线程就无法进入对象的同步方法或者同步控制块中，那么就无法执行 notify() 或者 notifyAll() 来唤醒挂起的线程，造成死锁。
  
  ```java
  public class WaitNotifyExample {
  
      public synchronized void before() {
          System.out.println("before");
          notifyAll();
      }
  
      public synchronized void after() {
          try {
              wait();
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          System.out.println("after");
      }
  }
  ```  
  
  ### await() signal() signalAll()
  
  java.util.concurrent 类库中提供了 Condition 类来实现线程之间的协调，可以在 Condition 上调用 await() 方法使线程等待，其它线程调用 signal() 或 signalAll() 方法唤醒等待的线程。
  
  相比于 wait() 这种等待方式，await() 可以指定等待的条件，因此更加灵活。
  
  使用 Lock 来获取一个 Condition 对象。
  
  
  ```java
  public class AwaitSignalExample {
  
      private Lock lock = new ReentrantLock();
      private Condition condition = lock.newCondition();
  
      public void before() {
          lock.lock();
          try {
              System.out.println("before");
              condition.signalAll();
          } finally {
              lock.unlock();
          }
      }
  
      public void after() {
          lock.lock();
          try {
              condition.await();
              System.out.println("after");
          } catch (InterruptedException e) {
              e.printStackTrace();
          } finally {
              lock.unlock();
          }
      }
  }
  ```
  
# 线程状态

一个线程只能处于一种状态，并且这里的线程状态特指 Java 虚拟机的线程状态，不能反映线程在特定操作系统下的状态。

### 新建（NEW）

创建后尚未启动。

### 可运行（RUNNABLE）

正在 Java 虚拟机中运行。但是在操作系统层面，它可能处于运行状态，也可能等待资源调度（例如处理器资源），资源调度完成就进入运行状态。所以该状态的可运行是指可以被运行，具体有没有运行要看底层操作系统的资源调度。

### 阻塞（BLOCKED）

请求获取 monitor lock 从而进入 synchronized 函数或者代码块，但是其它线程已经占用了该 monitor lock，所以出于阻塞状态。要结束该状态进入从而 RUNABLE 需要其他线程释放 monitor lock。

### 无限期等待（WAITING）

等待其它线程显式地唤醒。

阻塞和等待的区别在于，阻塞是被动的，它是在等待获取 monitor lock。而等待是主动的，通过调用 Object.wait() 等方法进入。

|进入方法|	退出方法|
| --- | --- |
|没有设置 Timeout 参数的 Object.wait() 方法	|Object.notify() / Object.notifyAll()|
|没有设置 Timeout 参数的 Thread.join() 方法	|被调用的线程执行完毕|
|LockSupport.park() 方法|	LockSupport.unpark(Thread)|

### 限期等待（TIMED_WAITING）
无需等待其它线程显式地唤醒，在一定时间之后会被系统自动唤醒。

|进入方法|退出方法|
| --- | --- |
|Thread.sleep() 方法|时间结束|
|Thread.sleep() 方法|时间结束|
|设置了 Timeout 参数的 Object.wait() 方法	|时间结束 / Object.notify() / Object.notifyAll()|
|设置了 Timeout 参数的 Thread.join() 方法	|时间结束 / 被调用的线程执行完毕|
|LockSupport.parkNanos() 方法	|LockSupport.unpark(Thread)|
|LockSupport.parkUntil() 方法	|LockSupport.unpark(Thread)|

调用 Thread.sleep() 方法使线程进入限期等待状态时，常常用“使一个线程睡眠”进行描述。调用 Object.wait() 方法使线程进入限期等待或者无限期等待时，常常用“挂起一个线程”进行描述。睡眠和挂起是用来描述行为，而阻塞和等待用来描述状态。

### 死亡（TERMINATED）

可以是线程结束任务之后自己结束，或者产生了异常而结束。

[Java SE 9 Enum Thread.State](https://docs.oracle.com/javase/9/docs/api/java/lang/Thread.State.html)

# AQS - Abstract Queued Synchronizer

  ### [CountDownLatch](https://www.jianshu.com/p/965ffb474d89)
  CountDownLatch是java.util.concurrent包中的一个类，它主要用来协调多个线程之间的同步，起到一个同步器的作用。总的来说，CountDownLatch让一个或多个线程在运行过程中的某个时间点能停下来等待其他的一些线程完成某些任务后再继续运行。
  
  ```java
  public class CountdownLatchExample {
  
      public static void main(String[] args) throws InterruptedException {
          final int totalThread = 10;
          CountDownLatch countDownLatch = new CountDownLatch(totalThread);
          ExecutorService executorService = Executors.newCachedThreadPool();
          for (int i = 0; i < totalThread; i++) {
              executorService.execute(() -> {
                  System.out.print("run..");
                  countDownLatch.countDown();
              });
          }
          countDownLatch.await();
          System.out.println("end");
          executorService.shutdown();
      }
  }
  ```
  ### [CyclicBarrier](https://www.jianshu.com/p/424374d71b67)
  
  可以让一组线程达到一个屏障时被阻塞，直到最后一个线程达到屏障时，所以被阻塞的线程才能继续执行。
  CyclicBarrier好比一扇门，默认情况下关闭状态，堵住了线程执行的道路，直到所有线程都就位，门才打开，让所有线程一起通过。
  
  ```java
  public class CyclicBarrierExample {
  
      public static void main(String[] args) {
          final int totalThread = 10;
          CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
          ExecutorService executorService = Executors.newCachedThreadPool();
          for (int i = 0; i < totalThread; i++) {
              executorService.execute(() -> {
                  System.out.print("before..");
                  try {
                      cyclicBarrier.await();
                  } catch (InterruptedException | BrokenBarrierException e) {
                      e.printStackTrace();
                  }
                  System.out.print("after..");
              });
          }
          executorService.shutdown();
      }
  }
  ```  
  ### [Semaphore](https://www.jianshu.com/p/0090341c6b80)
  Semaphore也叫信号量，在JDK1.5被引入，可以用来控制同时访问特定资源的线程数量，通过协调各个线程，以保证合理的使用资源。
  
  Semaphore内部维护了一组虚拟的许可，许可的数量可以通过构造函数的参数指定。
  
  访问特定资源前，必须使用acquire方法获得许可，如果许可数量为0，该线程则一直阻塞，直到有可用许可。
  访问资源后，使用release释放许可。
  
  ```java
  public class SemaphoreExample {
  
      public static void main(String[] args) {
          final int clientCount = 3;
          final int totalRequestCount = 10;
          Semaphore semaphore = new Semaphore(clientCount);
          ExecutorService executorService = Executors.newCachedThreadPool();
          for (int i = 0; i < totalRequestCount; i++) {
              executorService.execute(()->{
                  try {
                      semaphore.acquire();
                      System.out.print(semaphore.availablePermits() + " ");
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  } finally {
                      semaphore.release();
                  }
              });
          }
          executorService.shutdown();
      }
  }
  ```
  ### FutureTask
  在介绍 Callable 时我们知道它可以有返回值，返回值通过 Future 进行封装。FutureTask 实现了 RunnableFuture 接口，该接口继承自 Runnable 和 Future 接口，这使得 FutureTask 既可以当做一个任务执行，也可以有返回值。
  
  FutureTask 可用于异步获取执行结果或取消执行任务的场景。当一个计算任务需要执行很长时间，那么就可以用 FutureTask 来封装这个任务，主线程在完成自己的任务之后再去获取结果。
  
  ```java
  public class FutureTaskExample {
  
      public static void main(String[] args) throws ExecutionException, InterruptedException {
          FutureTask<Integer> futureTask = new FutureTask<Integer>(new Callable<Integer>() {
              @Override
              public Integer call() throws Exception {
                  int result = 0;
                  for (int i = 0; i < 100; i++) {
                      Thread.sleep(10);
                      result += i;
                  }
                  return result;
              }
          });
  
          Thread computeThread = new Thread(futureTask);
          computeThread.start();
  
          Thread otherThread = new Thread(() -> {
              System.out.println("other task is running...");
              try {
                  Thread.sleep(1000);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          });
          otherThread.start();
          System.out.println(futureTask.get());
      }
  }
  ```
  ### [BlockingQueue](https://www.jianshu.com/p/6ba87c7508e4)
  
  java.util.concurrent.BlockingQueue 接口有以下阻塞队列的实现：
  
  - FIFO 队列 ：LinkedBlockingQueue、ArrayBlockingQueue（固定长度）
  - 优先级队列 ：PriorityBlockingQueue
  提供了阻塞的 take() 和 put() 方法：如果队列为空 take() 将阻塞，直到队列中有内容；如果队列为满 put() 将阻塞，直到队列有空闲位置。
  
  ```java
  public class ProducerConsumer {
  
      private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
  
      private static class Producer extends Thread {
          @Override
          public void run() {
              try {
                  queue.put("product");
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.print("produce..");
          }
      }
  
      private static class Consumer extends Thread {
  
          @Override
          public void run() {
              try {
                  String product = queue.take();
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
              System.out.print("consume..");
          }
      }
  }
  ```
  
  ### ForkJoin
  主要用于并行计算中，和 MapReduce 原理类似，都是把大的计算任务拆分成多个小任务并行计算。
  
  ```java
  public class ForkJoinExample extends RecursiveTask<Integer> {
  
      private final int threshold = 5;
      private int first;
      private int last;
  
      public ForkJoinExample(int first, int last) {
          this.first = first;
          this.last = last;
      }
  
      @Override
      protected Integer compute() {
          int result = 0;
          if (last - first <= threshold) {
              // 任务足够小则直接计算
              for (int i = first; i <= last; i++) {
                  result += i;
              }
          } else {
              // 拆分成小任务
              int middle = first + (last - first) / 2;
              ForkJoinExample leftTask = new ForkJoinExample(first, middle);
              ForkJoinExample rightTask = new ForkJoinExample(middle + 1, last);
              leftTask.fork();
              rightTask.fork();
              result = leftTask.join() + rightTask.join();
          }
          return result;
      }
  }
  ```

# 线程不安全示例 [Source Code](../../src/main/java/com/concurrency/ThreadUnsafeExample.java)

如果多个线程对同一个共享数据进行访问而不采取同步操作的话，那么操作的结果是不一致的。

# Java 内存模型

  ### 主内存与工作内存
  
  处理器上的寄存器的读写的速度比内存快几个数量级，为了解决这种速度矛盾，在它们之间加入了高速缓存。
  
  加入高速缓存带来了一个新的问题：缓存一致性。如果多个缓存共享同一块主内存区域，那么多个缓存的数据可能会不一致，需要一些协议来解决这个问题。
 
  所有的变量都存储在主内存中，每个线程还有自己的工作内存，工作内存存储在高速缓存或者寄存器中，保存了该线程使用的变量的主内存副本拷贝。
  
  线程只能直接操作工作内存中的变量，不同线程之间的变量值传递需要通过主内存来完成。
  
  ### 内存间交互操作
  
  Java 内存模型定义了 8 个操作来完成主内存和工作内存的交互操作。
  
  - read：把一个变量的值从主内存传输到工作内存中
  - load：在 read 之后执行，把 read 得到的值放入工作内存的变量副本中
  - use：把工作内存中一个变量的值传递给执行引擎
  - assign：把一个从执行引擎接收到的值赋给工作内存的变量
  - store：把工作内存的一个变量的值传送到主内存中
  - write：在 store 之后执行，把 store 得到的值放入主内存的变量中
  - lock：作用于主内存的变量
  - unlock
  
  ### 内存模型三大特性
  
  - 原子性
    
    Java 内存模型保证了 read、load、use、assign、store、write、lock 和 unlock 操作具有原子性，例如对一个 int 类型的变量执行 assign 赋值操作，这个操作就是原子性的。但是 Java 内存模型允许虚拟机将没有被 volatile 修饰的 64 位数据（long，double）的读写操作划分为两次 32 位的操作来进行，即 load、store、read 和 write 操作可以不具备原子性。
    
  - 可见性
    可见性指当一个线程修改了共享变量的值，其它线程能够立即得知这个修改。Java 内存模型是通过在变量修改后将新值同步回主内存，在变量读取前从主内存刷新变量值来实现可见性的。
    
    主要有三种实现可见性的方式：
    
    - volatile
    - synchronized，对一个变量执行 unlock 操作之前，必须把变量值同步回主内存。
    - final，被final关键字修饰的字段在构造器中一旦初始化完成，并且没有发生this逃逸（其它线程通过this引用访问到初始化了一半的对象），那么其它线程就能看见final 字段的值。
  - 有序性
    
    有序性是指：在本线程内观察，所有操作都是有序的。在一个线程观察另一个线程，所有操作都是无序的，无序是因为发生了指令重排序。在 Java 内存模型中，允许编译器和处理器对指令进行重排序，重排序过程不会影响到单线程程序的执行，却会影响到多线程并发执行的正确性。
    
    volatile 关键字通过添加内存屏障的方式来禁止指令重排，即重排序时不能把后面的指令放到内存屏障之前。
    
    也可以通过 synchronized 来保证有序性，它保证每个时刻只有一个线程执行同步代码，相当于是让线程顺序执行同步代码。
  
  ### 先行发生原则
  - 单一线程原则
  - 管程锁定规则
  - volatile 变量规则
  - 线程启动规则
  - 线程加入规则
  - 线程中断规则
  - 对象终结规则
  - 传递性
  
# 线程安全

线程安全有以下几种实现方式：

### 不可变

不可变的类型：
  
  - final 关键字修饰的基本数据类型
  - String
  - 枚举类型
  - Number 部分子类，如 Long 和 Double 等数值包装类型，BigInteger 和 BigDecimal 等大数据类型。但同为 Number 的原子类 AtomicInteger 和 AtomicLong 则是可变的。
  
### 互斥同步
 - 非阻塞同步
   - CAS
   - AtomicInteger
   - ABA
 - 无同步方案
   - 栈封闭
   - 线程本地存储（Thread Local Storage）
     
     如果一段代码中所需要的数据必须与其他代码共享，那就看看这些共享数据的代码是否能保证在同一个线程中执行。如果能保证，我们就可以把共享数据的可见范围限制在同一个线程之内，这样，无须同步也能保证线程之间不出现数据争用的问题。
     符合这种特点的应用并不少见，大部分使用消费队列的架构模式（如“生产者-消费者”模式）都会将产品的消费过程尽量在一个线程中消费完。其中最重要的一个应用实例就是经典 Web 交互模型中的“一个请求对应一个服务器线程”（Thread-per-Request）的处理方式，这种处理方式的广泛应用使得很多 Web 服务端应用都可以使用线程本地存储来解决线程安全问题。
     可以使用 java.lang.ThreadLocal 类来实现线程本地存储功能。   
   - 可重入代码（Reentrant Code）
     
     可重入代码有一些共同的特征，例如不依赖存储在堆上的数据和公用的系统资源、用到的状态量都由参数中传入、不调用非可重入的方法等。
     
# 锁优化

这里的锁优化主要是指 JVM 对 synchronized 的优化。

- 自旋锁
- 锁消除
- 锁粗化
- 轻量级锁
- 偏向锁

# 多线程开发良好的实践
- 给线程起个有意义的名字，这样可以方便找 Bug。
  
- 缩小同步范围，从而减少锁争用。例如对于 synchronized，应该尽量使用同步块而不是同步方法。
  
- 多用同步工具少用 wait() 和 notify()。首先，CountDownLatch, CyclicBarrier, Semaphore 和 Exchanger 这些同步类简化了编码操作，而用 wait() 和 notify() 很难实现复杂控制流；其次，这些同步类是由最好的企业编写和维护，在后续的 JDK 中还会不断优化和完善。
  
- 使用 BlockingQueue 实现生产者消费者问题。
  
- 多用并发集合少用同步集合，例如应该使用 ConcurrentHashMap 而不是 Hashtable。
  
- 使用本地变量和不可变类来保证线程安全。
  
- 使用线程池而不是直接创建线程，这是因为创建线程代价很高，线程池可以有效地利用有限的线程来启动任务。

# [Home](../../README.md)