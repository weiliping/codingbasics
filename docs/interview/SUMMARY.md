# Data structure and algorithm

1. 常用排序

    - 插入, 选择，冒泡 （n*n）
    - 快排，归并，堆排序，希尔排序(n*log(n))
    - 计数排序，桶排序

2. 算法
    
    - 通用
        - 贪心算法
        - 分治算法
        - 回溯算法
        - 动态规划
        - 递归
        - 广度优先查询 - BFS
        - 深度优先查询 - DFS
        - 二分法查询 - Binary Search
        - 树的前、中、后序遍历
        - 哈希算法
        - 字符串匹配
    - Patterns for Coding Questions
        - Sliding Window
        - Two Pointers
        - Fast & Slow pointers
        - Merge Intervals
        - Cyclic Sort
        - In-place Reversal of a LinkedList
        - Tree Breadth First Search
        - Tree Depth First Search
        - Two Heaps
        - Subsets
        - Modified Binary Search
        - Bitwise XOR
        - Top 'K' Elements
        - K-way merge
        - 0/1 Knapsack (Dynamic Programming)
        - Topological Sort (Graph) 
            
3. 数据结构

    - 数组
        - Arrays
        - ListArray
    
    - 链表 
        - LinkedList   
        
    - 跳表
    
    - Hash
        - HashMap
        - HashSet
    
    - 栈
        - LinkedList
        - Stack
        - ArrayDeque
    
    - 队列
        - PriorityQueue
        - ArrayDeque
        - LinkedList
        - Queue（接口）
    
    - 双向队列
        - ArrayDeque
        - LinkedList
    
    - 树
        - TreeMap
        - TreeSet
  
    - Heap
        - PriorityQueue
    
    - 图
        - 邻接矩阵（二维矩阵）
        - 邻接表（一维数组 + 链表）
    
    - Trie (字典树)
        - 链表 + 数组
    
    - [并查集](https://www.cnblogs.com/hapjin/p/5478352.html)
        - 一维数组
        - 链表
    
# JVM

- 程序计数器
- 方法栈
- 本地方法区
- 方法区
- Java堆

# Java Concurrency
```java
    public class Lock {
        ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    
        public void sampleWriteLock() {
            ReentrantReadWriteLock.WriteLock l = lock.writeLock();
            try {
                l.lock();
            } finally {
                l.unlock();
            }
        }
        
        public void sampleReadLock() {
            ReentrantReadWriteLock.ReadLock l = lock.readLock();
            try {
                l.lock();
            } finally {
                l.unlock();
            }
        }
    }
```

# System Design

Availability
Performance
Reliability
Scalability
Manageability
Cost

Proxy
Loadbalancer
Services (redundancy & replication)
Partition
Cache
Queue
Index

CAP定理又称CAP原则，指的是在一个分布式系统中：Consistency（一致性）、 Availability（可用性）、Partition tolerance（分区容错性），最多只能同时三个特性中的两个，三者不可兼得，最多满足其中的两个特性。

可用性
可靠性
高效
可扩展性
易维护
费用

kiss keep it simple and stupid 不要过度设计
dry don't repeat yourself 
s 单一职责原则
o 开闭原则
l 里氏替换原则
i 接口隔离原则
d 依赖倒置原则