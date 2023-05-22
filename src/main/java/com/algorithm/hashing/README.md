##[interviewbit] Largest Continuous Sequence Zero Sum
Find the largest continuous sequence in a array which sums to zero.

Example:

```
Input:  {1 ,2 ,-2 ,4 ,-4}
Output: {2 ,-2 ,4 ,-4}
```

- Q: [Largest Continuous Sequence Zero Sum](https://www.interviewbit.com/problems/largest-continuous-sequence-zero-sum/)
- A: [LargestConArrSumZero.java](https://github.com/weiliping/lc/blob/master/src/main/java/com/leetcode/hashing/LargestConArrSumZero.java)


##[LeetCode] 166. Fraction to Recurring Decimal
给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以字符串形式返回小数。

如果小数部分为循环小数，则将循环的部分括在括号内。

示例 1:
```
输入: numerator = 1, denominator = 2
输出: "0.5"
```

示例 2:
```
输入: numerator = 2, denominator = 1
输出: "2"
```

示例 3:
```
输入: numerator = 2, denominator = 3
输出: "0.(6)"
```


[Fraction to Recurring Decimal](https://leetcode-cn.com/problems/fraction-to-recurring-decimal)


##[LeetCode] 49. Group Anagrams
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
```
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
```

说明：
- 所有输入均为小写字母。
- 不考虑答案输出的顺序。


[Group Anagrams](https://leetcode-cn.com/problems/group-anagrams)


##[LeetCode] 138. Copy List with Random Pointer
给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。

要求返回这个链表的`深拷贝`。 

我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个`[val, random_index]`表示：

- `val`：一个表示`Node.val`的整数。
- `random_index`：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为 `null`。
 

示例 1：
```
输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
```
示例 2：
```
输入：head = [[1,1],[2,1]]
输出：[[1,1],[2,1]]
```

示例 3：
```
输入：head = [[3,null],[3,0],[3,null]]
输出：[[3,null],[3,0],[3,null]]
```

示例 4：
```
输入：head = []
输出：[]
解释：给定的链表为空（空指针），因此返回 null。
```
[Copy List with Random Pointer](https://leetcode-cn.com/problems/copy-list-with-random-pointer)