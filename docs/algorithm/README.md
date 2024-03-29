# 算法
   * 排序算法 [Sort](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/07.%E6%8E%92%E5%BA%8F.md)
       * 算法详解 [Sort Algorithm](https://github.com/weiliping/DataStructure-BeautyOfAlgorithm/blob/master/docs/07.%E6%8E%92%E5%BA%8F.md)
       * 常见排序算法 [Sort](./sort/README.md)
       * 算法实现（Java）
         - 冒泡排序 [BubbleSort](../../src/main/java/com/algorithm/sort/BubbleSort.java)
         - 插入排序 [InsertSort](../../src/main/java/com/algorithm/sort/InsertSort.java)
         - 选择排序 [SelectionSort](../../src/main/java/com/algorithm/sort/SelectionSort.java)
         - 归并排序 [MergeSort](../../src/main/java/com/algorithm/sort/MergeSort.java)
         - 快速排序 [QuickSort](../../src/main/java/com/algorithm/sort/QuickSort.java)
         - 桶排序 [BucketSort](../../src/main/java/com/algorithm/sort/BucketSort.java)
         - 计数排序 [CountSort](../../src/main/java/com/algorithm/sort/CountSort.java)
         - 基数排序 [RadixSort](../../src/main/java/com/algorithm/sort/RadixSort.java)
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
# 常用算法
### 贪心算法
贪心算法（又称贪婪算法）是指，在对问题求解时，总是做出在当前看来是最好的选择。也就是说，不从整体最优上加以考虑，他所做出的是在某种意义上的局部最优解。

贪心算法不是对所有问题都能得到整体最优解，关键是贪心策略的选择，选择的贪心策略必须具备无后效性，即某个状态以前的过程不会影响以后的状态，只与当前状态有关。

- 分糖果
    - 我们有 m 个糖果和 n 个孩子。我们现在要把糖果分给这些孩子吃，但是糖果少，孩子多（m<n），所以糖果只能分配给一部分孩子。
- 钱币找零
- 区间覆盖
- 在一个非负整数 a 中，我们希望从中移除 k 个数字，让剩下的数字值最小，如何选择移除哪 k 个数字呢？
- 假设有 n 个人等待被服务，但是服务窗口只有一个，每个人需要被服务的时间长度是不同的，如何安排被服务的先后顺序，才能让这 n 个人总的等待时间最短？

### 分治算法
在计算机科学中，分治法是构建基于多项分支递归的一种很重要的算法范式。字面上的解释是「分而治之」，就是把一个复杂的问题分成两个或更多的相同或相似的子问题，直到最后子问题可以简单的直接求解，原问题的解即子问题的解的合并。

这个技巧是很多高效算法的基础，如排序算法（快速排序、归并排序）、傅立叶变换（快速傅立叶变换）。

- 二分搜索
- 大整数乘法
- Strassen矩阵乘法
- 棋盘覆盖
- 合并排序
- 快速排序
- 线性时间选择
- 最接近点对问题
- 循环赛日程表
- 汉诺塔

### 回溯算法
回溯算法实际上一个类似枚举的搜索尝试过程，主要是在搜索尝试过程中寻找问题的解，当发现已不满足求解条件时，就 “回溯” 返回，尝试别的路径。回溯法是一种选优搜索法，按选优条件向前搜索，以达到目标。但当探索到某一步时，发现原先选择并不优或达不到目标，就退回一步重新选择，这种走不通就退回再走的技术为回溯法，而满足回溯条件的某个状态的点称为 “回溯点”。许多复杂的，规模较大的问题都可以使用回溯法，有“通用解题方法”的美称。

回溯算法的基本思想是：从一条路往前走，能进则进，不能进则退回来，换一条路再试。

 ```bash
 result = []
 def backtrack(路径, 选择列表):
     if 满足结束条件:
         result.add(路径)
         return

     for 选择 in 选择列表:
         做选择
         backtrack(路径, 选择列表)
         撤销选择
 ```
 - 全排列问题
 - N 皇后问题

### 动态规划
动态规划（英语：Dynamic programming，简称 DP）是一种在数学、管理科学、计算机科学、经济学和生物信息学中使用的，通过把原问题分解为相对简单的子问题的方式求解复杂问题的方法。

动态规划不是某一种具体的算法，而是一种算法思想：若要解一个给定问题，我们需要解其不同部分（即子问题），再根据子问题的解以得出原问题的解。

应用这种算法思想解决问题的可行性，对子问题与原问题的关系，以及子问题之间的关系这两方面有一些要求，它们分别对应了最优子结构和重复子问题。

- 最优子结构

  最优子结构规定的是子问题与原问题的关系。动态规划要解决的都是一些问题的最优解，即从很多解决问题的方案中找到最优的一个。当我们在求一个问题最优解的时候，如果可以把这个问题分解成多个子问题，然后递归地找到每个子问题的最优解，最后通过一定的数学方法对各个子问题的最优解进行组合得出最终的结果。总结来说就是一个问题的最优解是由它的各个子问题的最优解决定的。

- 重复子问题

  重复子问题规定的是子问题与子问题的关系。当我们在递归地寻找每个子问题的最优解的时候，有可能会会重复地遇到一些更小的子问题，而且这些子问题会重叠地出现在子问题里，出现这样的情况，会有很多重复的计算，动态规划可以保证每个重叠的子问题只会被求解一次。当重复的问题很多的时候，动态规划可以减少很多重复的计算。

- 例题
    - 背包问题
    - 分割等和子集






