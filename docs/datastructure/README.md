# 数据结构&算法    
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
# 算法
   * 排序 [Sort](../algorithm/sort/README.md)
       - 算法详解 [Sort](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/07.%E6%8E%92%E5%BA%8F.md)
       * 冒泡排序 [BubbleSort](../../src/main/java/com/algorithm/sort/BubbleSort.java)
       * 插入排序 [InsertSort](../../src/main/java/com/algorithm/sort/InsertSort.java)
       * 选择排序 [SelectionSort](../../src/main/java/com/algorithm/sort/SelectionSort.java)
       * 归并排序 [MergeSort](../../src/main/java/com/algorithm/sort/MergeSort.java)
       * 快速排序 [QuickSort](../../src/main/java/com/algorithm/sort/QuickSort.java)
       * 桶排序 [BucketSort](../../src/main/java/com/algorithm/sort/BucketSort.java)
       * 计数排序 [CountSort](../../src/main/java/com/algorithm/sort/CountSort.java)
       * 基数排序 [RadixSort](../../src/main/java/com/algorithm/sort/RadixSort.java)
   * 二分法查找 [Binary Search](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/09.%E4%BA%8C%E5%88%86%E6%9F%A5%E6%89%BE.md)
       * 二分查找的思想
            - 二分查找针对的是一个有序的数据集合，查找思想有点类似分治思想。每次都通过跟区间的中间元素对比，将待查找的区间缩小为之前的一半，直到找到要查找的元素，或者区间被缩小为 0。
       * 二分查找的实现 [Binary Search Implement](../../src/main/java/com/datastructure/BinarySearch.java)
       ```java
       public class BinarySearch {
           public int binarySearch(int[] nums, int val) {
               if (nums == null || nums.length == 0) {
                   return -1;
               }
               int low = 0, high = nums.length - 1;
               while (low <= high) {
                   int mid = (low + high) / 2;
                   if (nums[mid] == val) {
                       return mid;
                   }
                   if (nums[mid] < val) {
                       low = mid + 1;
                       continue;
                   }
                   high = mid - 1;
               }
               return -1;
           }
       }
       ```
       * 二分查找应用场景的局限性
            - 二分查找依赖的是顺序表结构，即数组
            - 二分查找要求数据必须是有序的，或者无序但没有频繁的插入和删除操作
            - 数据量太小二分查找性能提升不大
            - 数据量太大不适合二分查找
       * 二分查找的三种变体
            - 查找第一个值等于给定值的元素
            - 查找最后一个值等于给定值的元素
            - 查找第一个大于等于给定值的元素
            - 查找最后一个小于等于给定值的元素
   * 搜索 [BFS&DFS](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/18.%E6%B7%B1%E5%BA%A6%E5%92%8C%E5%B9%BF%E5%BA%A6%E4%BC%98%E5%85%88%E6%90%9C%E7%B4%A2.md)
       * 广度和深度优先搜索
            - 广度优先搜索，采用地毯式层层推进，从起始顶点开始，依次往外遍历。广度优先搜索需要借助队列来实现，遍历得到的路径就是起始顶点到终止顶点的最短路径。
            - 深度优先搜索，采用回溯思想，适合用递归或栈来实现。遍历得到的路径并不是最短路径。
            - 深度优先和广度优先搜索的时间复杂度都是 O(E)，空间复杂度都是 O(V)。其中E代表边，O代表顶点。 
   * 哈希算法 [Hashing Algorithm](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/12.%E5%93%88%E5%B8%8C%E7%AE%97%E6%B3%95.md)
       * 哈希算法的应用
            - 安全加密
            - 唯一标识
            - 数据校验
            - 散列函数
            - 分布式系统中的应用有负载均衡、数据分片、分布式存储
       * 应用一：安全加密
            - MD5（MD5 Message-Digest Algorithm，MD5 消息摘要算法）
            - SHA（Secure Hash Algorithm，安全散列算法）
            - DES（Data Encryption Standard，数据加密标准）
            - AES（Advanced Encryption Standard，高级加密标准）
       * 应用二：唯一标识
            - 如果要在海量的图库中，搜索一张图是否存在 ，比较笨的办法就是，拿要查找的图片的二进制码串与图库中所有图片的二进制码串一一比对。如果相同，则说明图片在图库中存在。
       * 应用三：数据校验
            - 种子文件保存了 100 个文件块的哈希值。当文件块下载完成之后，通过相同的哈希算法，对下载好的文件块逐一求哈希值，然后跟种子文件中保存的哈希值比对。如果不同，说明这个文件块不完整或者被篡改了，需要再重新从其他宿主机器上下载这个文件块。
       * 应用四：散列函数
            - 散列函数也是哈希算法的一种应用，相对哈希算法的其他应用，散列函数对于散列算法冲突的要求要低很多
       * 应用五：负载均衡
            - 通过哈希算法，对客户端 IP 地址或者会话 ID 计算哈希值，将取得的哈希值与服务器列表的大小进行取模运算，最终得到的值就是应该被路由到的服务器编号。
       * 应用六：数据分片
            - 假如1T 的日志文件，里面记录了用户的搜索关键词，想要快速统计出每个关键词被搜索的次数，该怎么做呢？
            - 为了提高处理的速度，用 n 台机器并行处理。从搜索记录的日志文件中，依次读出每个搜索关键词，并且通过哈希函数计算哈希值，然后再跟 n 取模，最终得到的值分配到指定的机器上。
       * 应用七：分布式存储
            - 一致性哈希算法
                - 首先用哈希算法求出服务器（一般用ip地址或主机名）的哈希值与$2^{32}$取模，将其映射到$0～2^{32}$的Hash环上。
                - 然后采用同样的哈希算法求出存储数据的键的哈希值与$2^{32}$取模，映射到相同的Hash环上。
                - 然后从数据映射到的位置开始顺时针查找，将数据保存到找到的第一个服务器上。由于映射在环上，超过$2^{32}$仍然找不到服务器就会指向第一台服务器。       
   * 递归 [Recursion](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/06.%E9%80%92%E5%BD%92.md)
       * 递归需要满足的三个条件
            - 一个问题的解可以分解为几个子问题的解
            - 这个问题与分解之后的子问题，除了数据规模不同，求解思路完全一样
            - 存在递归终止条件
       * 递归代码要警惕堆栈溢出
            - 如何避免出现堆栈溢出呢？
            - 方法之一是在代码中限制递归调用的最大深度，递归调用超过一定深度（比如 1000）之后，就直接返回报错。
       * 递归代码要警惕重复计算
            - 为了避免重复计算，我们可以通过一个数据结构（比如散列表）来保存已经求解过的 f(k)。
   * 字符串匹配 [String Matching](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/19.%E5%AD%97%E7%AC%A6%E4%B8%B2%E5%8C%B9%E9%85%8D%E5%9F%BA%E7%A1%80.md)
       * 字符串匹配算法
            - BF （Brute Force）算法，中文叫作暴力匹配算法，也叫朴素匹配算法
            - RK 算法
                - RK 算法的思路：先通过哈希算法对主串中的 n-m+1 个子串分别求哈希值，然后逐个与模式串的哈希值比较大小。如果某个子串的哈希值与模式串相等，那就再对比一下子串和模式串本身。如果子串的哈希值与模式串的哈希值不相等，那对应的子串和模式串肯定也是不匹配的。
            - BM 算法
                - 核心思想：在模式串与主串匹配的过程中，当模式串和主串某个字符不匹配的时候，能够跳过一些肯定不会匹配的情况，将模式串往后多滑动几位。
            - KMP算法
                - KMP 算法的核心思想是在模式串和主串匹配的过程中，每当遇到坏字符后，对于已经比对过的好前缀，根据某种规律将模式串一次性滑动很多位。        
   * 贪心算法 [Greedy](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/22.%E8%B4%AA%E5%BF%83%E7%AE%97%E6%B3%95.md)
       * 有一个可以容纳 100kg 物品的背包，可以装以下 5 种豆子，每种豆子装多少能够让背包中所装物品的总价值最大？
         
         | 物品 | 重量(kg) | 总价值(元) |
         | ---- | -------- | ---------- |
         | 黄豆 | 100      | 100        |
         | 绿豆 | 30       | 90         |
         | 红豆 | 60       | 120        |
         | 黑豆 | 20       | 80         |
         | 青豆 | 50       | 75         |
       * 实例分析
            - 分糖果
                - 有 m 个糖果和 n 个孩子，但是m<n。
                  每个糖果的大小不等，这 m 个糖果的大小分别是 s1，s2，s3，……，sm。
                  每个孩子对糖果大小的需求不一样的，只有糖果的大小大于等于孩子的对糖果大小的需求的时候，孩子才得到满足。这 n 个孩子对糖果大小的需求分别是 g1，g2，g3，……，gn。
                  如何分配糖果，能尽可能满足最多数量的孩子？
            - 钱币找零
                - 假设有 1 元、2 元、5 元、10 元、20 元、50 元、100 元这些面额的纸币，它们的张数分别是 c1、c2、c5、c10、c20、c50、c100。现在要用这些钱来支付 K 元，最少要用多少张纸币呢？
            - 区间覆盖
                - 假设有 n 个区间，区间的起始端点和结束端点分别是 [l1, r1]，[l2, r2]，[l3, r3]，……，[ln, rn]。从这 n 个区间中选出一部分区间，这部分区间满足两两不相交（端点相交的情况不算相交），最多能选出多少个区间呢？ 
   * 分治算法 [Divide and Conquer](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/23.%E5%88%86%E6%B2%BB%E7%AE%97%E6%B3%95.md)
       * 概念
            - 将原问题划分成 n 个规模较小而结构与原问题相似的子问题，递归地解决这些子问题，然后再合并其结果，就得到原问题的解
       * 应用场景 
            - 用来指导编码，降低问题求解的时间复杂度；
            - 解决海量数据处理问题。
       * 应用举例
            - 求数组的逆序对个数
            - 求距离最近的两个点
            - 在海量数据处理中的应用
   * 回溯算法 [Backtracking](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/24.%E5%9B%9E%E6%BA%AF%E7%AE%97%E6%B3%95.md)
       * 概念
            - 回溯的处理思想，有点类似枚举搜索。枚举所有的解，找到满足期望的解。
       * 应用举例
            - 八皇后问题
            - 0-1背包
            - 正则表达式
   * 动态规划 [Dynamic Programming](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/25.%E5%8A%A8%E6%80%81%E8%A7%84%E5%88%92.md)
       * 思想
            - 将复杂问题拆分成多个较简单的子问题
            - 对每个子问题只计算一次，然后使用数据结构（数组，字典等）在内存中存储计算结果
            - 子问题的计算结果按照一定规则进行排序（如，基于输入参数）
            - 当需要再次运算子问题时直接使用已存储的计算结果而非再次运算以提升求解性能
       * 应用举例
            - 求斐波拉契数列Fibonacci 
            - 0-1背包问题
            - 最长公共子序列问题