# 数据结构
   * 数组 [Array](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/02.%E6%95%B0%E7%BB%84.md)
        * 数组的低效操作
            - 数组插入、删除数据时需要搬移其他数据等
            - 每次的删除操作并不是真正地搬移数据，只是记录数据已经被删除。当数组没有更多空间存储数据时，我们再触发执行一次真正的删除操作，这样就大大减少了删除操作导致的数据搬移。
            - 插入，删除平均情况时间复杂度为 O(n)
        *  容器(ArrayList)
            - 支持动态扩容
            - Java ArrayList无法存储基本类型
        * Java类
            - [java.util.ArrayList](https://docs.oracle.com/javase/7/docs/api/java/util/ArrayList.html)
   * 链表 [Linked List](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/03.%E9%93%BE%E8%A1%A8.md)
        * 单链表
        * 循环链表
        * 双链表
        * 循环双链表
        * LRU缓存
            - 先进先出策略 FIFO（First In，First Out）
            - 最少使用策略 LFU（Least Frequently Used）
            - 最近最少使用策略 LRU（Least Recently Used）
        * 算法题
            - 实现单链表、循环链表、双向链表，支持增删操作
            - 实现单链表反转
            - 实现两个有序的链表合并为一个有序链表
            - 实现求链表的中间结点
        * Java类
            - [java.util.LinkedList](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
   * 栈 [Stack](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/04.%E6%A0%88.md)
        * 顺序栈 - 用数组实现的栈
        * 链式栈 - 用链表实现的栈
        * 实际应用
            - 函数调用栈
            - 栈实现表达式求值
            - 栈实现括号匹配
            - 实现浏览器的前进和后退功能
        * Java类
            - [java.util.Stack](https://docs.oracle.com/javase/7/docs/api/java/util/Stack.html)
            - [java.util.ArrayDeque](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)
   * 队列 [Queue](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/05.%E9%98%9F%E5%88%97.md)
        * 队列的实现
            - 顺序队列 - 用数组实现的队列
            - 链式队列 - 用链表实现的队列
            - 循环数组实现的队列
        * 实际应用
            - 阻塞队列(生产者 - 消费者模型)
            - 并发队列 - 基于数组的循环队列，利用CAS原子操作，可以实现非常高效的并发队列
            - 有限资源池
        * Java类
            - [Queue](https://docs.oracle.com/javase/8/docs/api/java/util/Queue.html)
                - [java.util.PriorityQueue](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)
                - [java.util.LinkedList](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
                - [java.util.ArrayDeque](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)
            - [Deque](https://docs.oracle.com/javase/8/docs/api/java/util/Deque.html)
                - [java.util.ArrayDeque](https://docs.oracle.com/javase/8/docs/api/java/util/ArrayDeque.html)
                - [java.util.LinkedList](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedList.html)
   * 堆 [Heap](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/16.%E5%A0%86.md)
        * 堆的概念
            - 堆是一个完全二叉树
            - 堆中每一个节点的值都必须大于等于（或小于等于）其子树中每个节点的值
        * 存储一个堆
            - 用数组来存储完全二叉树，通过数组的下标，就可以找到一个节点的左右子节点和父节点
        * 基于堆实现堆排序
            - 建堆
            - 排序
        * 堆的应用
            - 优先级队列
            - 合并有序小文件
            - 高性能定时器
            - 利用堆求 Top K
            - 利用堆求中位数
        * Java类
            - [java.util.PriorityQueue](https://docs.oracle.com/javase/8/docs/api/java/util/PriorityQueue.html)
   * 哈希表 [Hashing](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/11.%E6%95%A3%E5%88%97%E8%A1%A8.md)
        * 定义
            - 散列表用的是数组支持按照下标随机访问数据的特性，是数组的一种扩展
        * 两个核心问题
            - 散列函数设计
            - 散列冲突解决
                - 开放寻址法
                - 链表法
        * 哈希表的应用
            - 单词拼写检查功能
            - 10万条URL访问记录，按访问次数给URL排序
            - 找出2个数组中相同的字符串
        * 散列表的设计
            - 工业级的散列表的特性
                - 支持快速的查询、插入、删除操作
                - 内存占用合理，不能浪费过多的内存空间
                - 性能稳定，极端情况下，散列表的性能也不会退化到无法接受的情况
            - 散列表的设计思路
                - 设计一个合适的散列函数
                - 定义装载因子阈值，并且设计动态扩容策略
                - 选择合适的散列冲突解决方法
        * Java类
            - [java.util.HashSet](https://docs.oracle.com/javase/8/docs/api/java/util/HashSet.html)
            - [java.util.HashMap](https://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html)
            - [java.util.LinkedHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/LinkedHashMap.html)
            - [java.util.concurrent.ConcurrentHashMap](https://docs.oracle.com/javase/8/docs/api/java/util/concurrent/ConcurrentHashMap.html)
   * 跳表 [Skip List](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/10.%E8%B7%B3%E8%A1%A8.md)
        * 跳表=链表+多级索引
            - 跳表 - 链表加多级索引的结构
        * 跳表的时间复杂度分析
            - 时间复杂度 O(logn)
            - 空间复杂度 O(n)
            - 插入、删除操作的时间复杂度是 O(logn)
        * Redis用跳表实现有序集合, 核心操作主要有:
            - 插入一个数据；
            - 删除一个数据；
            - 查找一个数据；
            - 按照区间查找数据（比如查找值在 [100, 356] 之间的数据）；
            - 迭代输出有序序列
   * 树
       * 二叉树 [Binary Tree](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/13.%E4%BA%8C%E5%8F%89%E6%A0%91%E5%9F%BA%E7%A1%80.md)
            - 类型
                1. 普通二叉树
                2. 完全二叉树
            - 存储方式
                1. 链式存储
                2. 数组顺序存储
                    - 根节点存储在下标 i = 1 的位置，那左子节点存储在下标 2 * i = 2 的位置，右子节点存储在 2 * i + 1 = 3 的位置
            - 遍历操作
                1. 前、中、后序遍历
                    - 时间复杂度是 O(n)
                    - 用递归代码来实现
                2. 按层次遍历
                    - 按照广度优先的遍历算法的思路，引入一个队列
            - 二叉树的应用
                1. 二叉查找树
                    - 查找操作
                    - 插入操作
                    - 删除操作
                    - 快速地查找最大节点和最小节点、前驱节点和后继节点
                2. n个不同的数据可以构建出多少种不同的二叉树
                3. 求给定二叉树的确切高度
       * 递归树 [Recursion Tree](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/15.%E9%80%92%E5%BD%92%E6%A0%91.md)
            - 概念
                - 递归的思想就是，将大问题分解为小问题来求解，然后再将小问题分解为小小问题。如果把这个一层一层的分解过程画成图，它其实就是一棵树，这棵树就叫递归树
            - 归并排序递归代码的时间复杂度 O(nlogn)
            - 快速排序的时间复杂度 O(nlogn)
            - 斐波那契数列的时间复杂度 O(2^n)
            - 全排列的递归算法的时间复杂度在 O(n!)到 O(n*n!)之间
       * 红黑树 [Red–black Tree](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/14.%E7%BA%A2%E9%BB%91%E6%A0%91.md)
            - 动态数据结构优劣势对比
                - 散列表：插入删除查找都是O(1), 是最常用的，但其缺点是不能顺序遍历以及扩容缩容的性能损耗。适用于那些不需要顺序遍历，数据更新不那么频繁的。
                - 跳表：插入删除查找都是O(logn), 并且能顺序遍历。缺点是空间复杂度O(n)。适用于不那么在意内存空间的，其顺序遍历和区间查找非常方便。
                - 红黑树：插入删除查找都是O(logn), 中序遍历即是顺序遍历，稳定。缺点是难以实现，去查找不方便。
            - 红黑树
                - 根节点是黑色的；
                - 每个叶子节点都是黑色的空节点（NIL），叶子节点不存储数据；
                - 任何相邻的节点都不能同时为红色，红色节点是被黑色节点隔开的；
                - 每个节点，从该节点到达其可达叶子节点的所有路径都包含相同数目的黑色节点；
            - 平衡操作中两个非常重要的操作
                - 左旋（rotate left）全称叫围绕某个节点的左旋
                - 右旋（rotate right）全称叫围绕某个节点的右旋
       * Trie树 [Trie Tree](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/20.Trie%E6%A0%91.md)
            - 介绍
                - Trie 树也叫“字典树”，是一种专门处理字符串匹配的树形结构，用来解决在一组字符串集合中快速查找某个字符串的问题。
            - 实现Trie 树，Trie 树主要有两个操作：
                - 将字符串插入到 Trie 树中
                - 在 Trie 树中查询一个字符串
            - Trie树的适用场景
                - 自动输入补全
       * B+树 [B+ Tree](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/29.B%2B%E6%A0%91.md)
            - MySQL数据库索引的数据结构
            - 树中的节点并不存储数据本身，而是只是作为索引。除此之外，我们把每个叶子节点串在一条链表上，链表中的数据是从小到大有序的。
                - 插入操作
                - 删除操作
            - 构建m叉树索引m多大最合适呢
                - 在选择 m 大小的时候，要尽量让每个节点的大小等于一个页的大小。读取一个节点，只需要一次磁盘 IO 操作。
       * Java类
            - [java.util.TreeSet](https://docs.oracle.com/javase/8/docs/api/java/util/TreeSet.html)
            - [java.util.TreeMap](https://docs.oracle.com/javase/8/docs/api/java/util/TreeMap.html)
   * 图 [Graph](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/17.%E5%9B%BE%E7%9A%84%E8%A1%A8%E7%A4%BA.md)
       * 顶点&边
            - 图中的元素叫作顶点
            - 图一个顶点可以与任意其他顶点建立连接关系，这种建立的关系叫边(edge)
       * 有向图 & 无向图
       * 带权图