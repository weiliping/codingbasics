# Patterns for Coding Questions - [<b>RETURN</b>](../../README.md)
1. [Pattern: Sliding Window](#1-pattern-sliding-window)
2. [Pattern: Two Pointers](#2-pattern-two-pointers)
3. [Pattern: Fast & Slow pointers](#3-pattern-fast--slow-pointers)
4. [Pattern: Merge Intervals](#4-pattern-merge-intervals)
5. [Pattern: Cyclic Sort](#5-pattern-cyclic-sort)
6. [Pattern: In-place Reversal of a LinkedList](#6-pattern-in-place-reversal-of-a-linkedlist)
7. [Pattern: Tree Breadth First Search](#7-pattern-tree-breadth-first-search)
8. [Pattern: Tree Depth First Search](#8-pattern-tree-depth-first-search)
9. [Pattern: Two Heaps](#9-pattern-two-heaps)
10. [Pattern: Subsets](#10-pattern-subsets)
11. [Pattern: Modified Binary Search](#11-pattern-modified-binary-search)
12. [Pattern: Bitwise XOR](#12-pattern-bitwise-xor)
13. [Pattern: Top 'K' Elements](#13-pattern-top-k-elements)
14. [Pattern: K-way merge](#14-pattern-k-way-merge)
15. [Pattern : 0/1 Knapsack (Dynamic Programming)](#15-pattern--01-knapsack-dynamic-programming)
16. [Pattern: Topological Sort (Graph)](#16-pattern-topological-sort-graph)
17. [Miscellaneous](#17-miscellaneous)
18. [Reference](#reference)

## 1. Pattern: Sliding Window
- [Maximum Sum Subarray of Size K](slidingwindow/MaximumSubArraySum.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/arrays/MaximumSubarraySum.java) -->
- [Smallest Subarray with a given sum](slidingwindow/MinimumSizeSubarraySum.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/arrays/MinimumSizeSubarraySum.java) -->
- [Longest Substring with K Distinct Characters](slidingwindow/LongestSubstringKCharacters.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/LongestSubstringKCharacters.java) -->
- [Fruits into Baskets](slidingwindow/TotalFruit.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/TotalFruit.java) -->
- [No-repeat Substring](slidingwindow/NorepeatSubstring.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/strings/LengthOfLongestSubstring.java) --> *
- [Longest Substring with Same Letters after Replacement](slidingwindow/LongestRepeatingCharacterReplacement.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/CharacterReplacement.java) -->
- [Longest Subarray with Ones after Replacement](slidingwindow/MaxConsecutiveOnesIII.md) (<b>hard</b>) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/MaxConsecutiveOnes.java) --> *
- [Problem Challenge 1 - Permutation in a String](slidingwindow/PermutationInString.md) (<b>hard</b>) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/PermutationInString.java) --> *
- [Problem Challenge 2 - String Anagrams](slidingwindow/StringAnagrams.md) (<b>hard</b>) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/StringAnagrams.java) -->
- [Problem Challenge 3 - Smallest Window containing Substring](slidingwindow/MinimumWindowSubstring.md) (<b>hard</b>) <!-- [Java](../../src/main/java/com/algorithm/strings/MinWindow.java) --> *
- [Problem Challenge 4 - Words Concatenation](slidingwindow/WordsConcatenation.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/strings/SubstringWithAllWordsConcatenation.java) -->
    
## 2. Pattern: Two Pointers
- [Pair with Target Sum](twopointers/TwoNum.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/twopointers/PairWithTargetSum.java) -->
- [Remove Duplicates](twopointers/RemoveDuplicates.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/twopointers/RemoveDuplicates.java) -->
- [Squaring a Sorted Array](twopointers/SquaresSortedArray.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/twopointers/SquaringArray.java) -->
- [Triplet Sum to Zero](twopointers/3Sum.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/ThreeSum.java) [Solution](../../src/main/java/com/algorithm/arrays/ThreeSumClosest.java) -->
- [Triplet Sum Close to Target](twopointers/3SumClosest.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/TripletSumCloseToTarget.java) -->
- [Triplets with Smaller Sum](twopointers/3SumSmaller.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/ThreeSumSmaller.java) -->
- [Subarrays with Product Less than a Target](twopointers/ProductLessSubarray.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/FindSubarray.java) -->
- [Dutch National Flag Problem](twopointers/SortColors.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/DutchFlagSort.java) [Solution](../../src/main/java/com/algorithm/twopointers/SortColors.java) -->
- [Problem Challenge 1 - Quadruple Sum to Target](twopointers/QuadrupleSum.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/FourSum.java) --> *
- [Problem Challenge 2 - Comparing Strings containing Backspaces](twopointers/BackspaceStringCompare.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/twopointers/BackspaceCompare.java) -->
- [Problem Challenge 3 - Minimum Window Sort](twopointers/ShortestWindowSort.md) (<b>medium</b>) <!-- [Java](../../src/main/java/com/algorithm/twopointers/ShortestWindowSort.java) --> *

## 3. Pattern: Fast & Slow pointers
- [LinkedList Cycle](fastslowpointers/LinkedListCycle.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/CycleList.java) -->
- [Middle of the LinkedList](fastslowpointers/LinkedListMiddle.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/MiddleNode.java) -->
- [Start of LinkedList Cycle](fastslowpointers/DetectCycle.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/DetectCycle.java) -->
- [Happy Number](twopointers/HappyNumber.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/math/HappyNumber.java) -->
- [Problem Challenge 1 - Palindrome LinkedList](fastslowpointers/PalindromeList.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/PalindromeList.java) --> *
- [Problem Challenge 2 - Rearrange a LinkedList](fastslowpointers/ReorderLinkedList.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/ReorderList.java) -->
- [Problem Challenge 3 - Cycle in a Circular Array](fastslowpointers/CircularArrayLoop.md) (<b>hard</b>) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/CircularArrayLoop.java) -->*

## 4. Pattern: Merge Intervals
- [Merge Intervals](mergeintervals/MergeIntervals.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/MergeIntervals.java) -->
- [Insert Interval](mergeintervals/InsertIntervals.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/InsertInterval.java) -->
- [Intervals Intersection](mergeintervals/IntervalIntersections.md) (<b>medium</b>) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/IntervalIntersection.java) -->
- [Conflicting Appointments](mergeintervals/ConflictingAppointments.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/ConflictingAppointments.java) -->
- [Problem Challenge 1 - Minimum Meeting Rooms](mergeintervals/MeetingRoomII.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/MinMeetingRooms.java) --> *
- [Problem Challenge 2 - Maximum CPU Load](mergeintervals/MaximumProfitInJobScheduling.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/MaximumProfitJobScheduling.java) -->
- [Problem Challenge 3 - Employee Free Time](mergeintervals/EmployeeFreeTime.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/mergeintervals/EmployeeFreeTime.java) --> *

## 5. Pattern: Cyclic Sort
- [Cyclic Sort](cyclicsort/CyclicSort.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/cyclicsort/CyclicSort.java) -->
- [Find the Missing Number](cyclicsort/FirstMissingPositive.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/arrays/FirstMissingPositive.java) -->
- [Find all Missing Numbers](cyclicsort/FindMissingNumbers.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/cyclicsort/FindMissingNumbers.java) -->
- [Find the Duplicate Number](cyclicsort/FindDuplicateNumber.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/FindDuplicate.java) -->
- [Find all Duplicate Numbers](cyclicsort/FindAllDuplicates.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/cyclicsort/FindAllDuplicates.java) -->
- [Problem Challenge 1 - Find the Corrupt Pair](cyclicsort/FindCorruptPair.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/cyclicsort/FindCorruptPair.java) -->
- [Problem Challenge 2 - Find the Smallest Missing Positive Number](cyclicsort/FindMissingPositive.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/arrays/FirstMissingPositive.java) -->
- [Problem Challenge 3 - Find the First K Missing Positive Numbers](cyclicsort/FindFirstKMissingPositive.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/cyclicsort/FindFirstKMissingPositive.java) --> *

## 6. Pattern: In-place Reversal of a LinkedList
- [Reverse a LinkedList](reversallinkedlist/ReversalLinkedList.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/ReverseList.java) [Solution 2](../../src/main/java/com/algorithm/linkedlists/ReverseSubList.java) -->
- [Reverse a Sub-list](reversallinkedlist/ReverseLinkedListII.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/ReverseListII.java) -->
- [Reverse every K-element Sub-list](reversallinkedlist/ReverseNodesInKGroup.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/ReverseKGroup.java) -->
- [Problem Challenge 1 - Reverse alternating K-element Sub-list](reversallinkedlist/ReverseAlternateKNodes.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/ReverseAlternateKListNodes.java) -->
- [Problem Challenge 2 - Rotate a LinkedList](reversallinkedlist/RotateList.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/RotateList.java) -->

## 7. Pattern: Tree Breadth First Search
- [Binary Tree Level Order Traversal](bfs/TreeLevelOrderTraversal.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/LevelOrderTraversal.java) -->
- [Reverse Level Order Traversal](bfs/TreeLevelOrderTraversalII.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/LevelOrderTraversalII.java) -->
- [Zigzag Traversal](bfs/ZigzagTraversal.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/ZigzagLevelOrder.java) -->
- [Level Averages in a Binary Tree](bfs/AverageLevelsBinaryTree.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/AverageOfLevels.java) -->
- [Minimum Depth of a Binary Tree](bfs/MinimumDepth.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/MinimumDepth.java) -->
- [Level Order Successor](bfs/LevelOrderSuccessor.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/LevelOrderSuccessor.java) -->
- [Connect Level Order Siblings](bfs/ConnectSiblings.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/NodeConnect.java) -->
- [Problem Challenge 1 - Connect All Level Order Siblings](bfs/ConnectAllLevelOrderSiblings.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/ConnectAllLevelOrderSiblings.java) -->
- [Problem Challenge 2 - Right View of a Binary Tree](bfs/RightSideView.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/RightSideView.java) -->

## 8. Pattern: Tree Depth First Search
- [Binary Tree Path Sum](dfs/PathSum.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/PathSum.java) -->
- [All Paths for a Sum](dfs/PathSumII.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/RootToLeafPathsSum.java) -->
- [Sum of Path Numbers](dfs/SumRootToLeafNumbers.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/SumRootToLeafNumbers.java) -->
- [Path With Given Sequence](dfs/PathWithGivenSequence.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/PathWithGivenSequence.java) -->
- [Count Paths for a Sum](dfs/PathSumIII.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/PathSumIII.java) -->
- [Problem Challenge 1 - Tree Diameter](dfs/TreeDiameter.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/DiameterOfBinaryTree.java) --> *
- [Problem Challenge 2 - Path with Maximum Sum](dfs/MaxPathSum.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/treedatastructure/TreeMaxPathSum.java) -->*

## 9. Pattern: Two Heaps
- [Find the Median of a Number Stream](twoheaps/MedianFinder.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/design/MedianFinder.java) -->
- [Sliding Window Median](twoheaps/SlidingWindowMedian.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/slidingwindow/MedianSlidingWindow.java) -->
- [Maximize Capital](twoheaps/MaximizeCapital.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/twoheaps/MaximizedCapital.java) -->
- [Problem Challenge 1 - Next Interval](twoheaps/RightInterval.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/twoheaps/RightInterval.java) -->

## 10. Pattern: Subsets
- [Subsets](subsets/Subsets.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/backtracking/Subsets.java) -->
- [Subsets With Duplicates](subsets/SubsetsII.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/backtracking/SubsetsII.java) -->
- [Permutations](subsets/Permutations.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/backtracking/Permute.java) -->
- [String Permutations by changing case](subsets/LetterCasePermutations.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/subsets/LetterCasePermutation.java) -->
- [Balanced Parentheses](subsets/GenerateParentheses.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/backtracking/GenerateParenthesis.java) -->
- [Unique Generalized Abbreviations](subsets/GeneralizedAbbreviation.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/subsets/GenerateAbbreviations.java) -->
- [Problem Challenge 1 - Evaluate Expression](subsets/EvaluateExpression.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/subsets/EvaluateExpression.java) --> *
- [Problem Challenge 2 - Structurally Unique Binary Search Trees](subsets/StructurallyUniqueBinaryTrees.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/subsets/ConstructTrees.java) --> *
- [Problem Challenge 3 - Count of Structurally Unique Binary Search Trees](subsets/UniqueBinarySearchTrees.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/dynamicprogramming/UniqueBinarySearchTrees.java) -->

## 11. Pattern: Modified Binary Search
- [Order-agnostic Binary Search](binarysearch/BinarySearch.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/BinarySearch.java) -->
- [Ceiling of a Number](binarysearch/CeilingOfANumber.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/CeilingNumber.java) -->
- [Next Letter](binarysearch/NextLetter.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/NextLetter.java) -->
- [Number Range](binarysearch/NumberRange.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/SearchRange.java) -->
- [Search in a Sorted Infinite Array](binarysearch/SearchSortedInfiniteArray.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/SearchSortedInfiniteArray.java) -->
- [Minimum Difference Element](binarysearch/MinimumDifferenceElement.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/MinimumDifferenceElement.java) -->
- [Bitonic Array Maximum](binarysearch/BitonicArrayMaximum.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/BitonicArrayMaximum.java) -->
- [Problem Challenge 1 - Search Bitonic Array](binarysearch/SearchBitonicArray.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/arrays/FindPeakElement.java) -->
- [Problem Challenge 2 - Search in Rotated Array](binarysearch/SearchInRotatedArray.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/SearchInRotatedSortedArray.java) --> *
- [Problem Challenge 3 - Rotation Count](binarysearch/RotationCount.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/binarysearch/RotationCount.java) --> *

## 12. Pattern: Bitwise XOR
- [Single Number](bitwise/SingleNumber.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/bitmanipulation/SingleNumber.java) -->
- [Two Single Numbers](bitwise/SingleNumberIII.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/bitmanipulation/SingleNumberIII.java) -->
- [Complement of Base 10 Number](bitwise/ComplementBase10.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/bitmanipulation/NumberComplement.java) -->
- [Problem Challenge 1 - Flip an image](bitwise/FlipAnImage.md) (Easy) <!-- [Java](../../src/main/java/com/algorithm/bitmanipulation/FlipAnImage.java) -->

## 13. Pattern: Top 'K' Elements
- [Top 'K' Numbers](topkelements/TopKNumbers.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/FindKthLargest.java) -->
- [Kth Smallest Number](topkelements/KthSmallestNumber.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/KthSmallestI.java) -->
- ['K' Closest Points to the Origin](topkelements/KClosestPoints.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/KClosestPoints.java) -->
- [Connect Ropes](topkelements/ConnectRopes.md) (easy) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/ConnectRopes.java) -->
- [Top 'K' Frequent Numbers](topkelements/TopKFrequent.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/FindKthLargest.java) -->
- [Frequency Sort](topkelements/FrequencySort.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/FrequencySort.java) -->
- [Kth Largest Number in a Stream](topkelements/KthLargestNumber.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/KthLargest.java) -->
- ['K' Closest Numbers](topkelements/FindKClosestElements.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/FindClosestElements.java) -->
- [Maximum Distinct Elements](topkelements/MaximumDistinctElements.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/MaximumDistinctNumbers.java) -->
- [Sum of Elements](topkelements/SumOfElements.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/SumOfElements.java) -->
- [Rearrange String](topkelements/ReorganizeString.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/ReorganizeString.java) -->
- [Problem Challenge 1 - Rearrange String K Distance Apart](topkelements/RearrangeStringKDistanceApart.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/RearrangeStringKDistance.java) -->
- [Problem Challenge 2 - Scheduling Tasks](topkelements/SchedulingTasks.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/LeastInterval.java) [LeetCode solution](../../src/main/java/com/algorithm/stacksandqueues/LeastIntervalI.java) --> *  
- [Problem Challenge 3 - Frequency Stack](topkelements/MaximumFrequencyStack.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/FreqStack.java)  [LeetCode solution](../../src/main/java/com/algorithm/stacksandqueues/FreqStackI.java)-->

## 14. Pattern: K-way merge
- [Merge K Sorted Lists](kwaymerge/MergeKSortedList.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/linkedlists/MergeKSortedLists.java) -->
- [Kth Smallest Number in M Sorted Lists](kwaymerge/KthSmallestInSortedList.md) (Medium) <!-- [Java](../../src/main/java/com/algorithm/kmerge/KthSmallestInSortedList.java) -->
- [Kth Smallest Number in a Sorted Matrix](kwaymerge/KthSmallestElement.md) (Hard) <!-- [Java](../../src/main/java/com/algorithm/stacksandqueues/KthSmallest.java) [Solution 2](../../src/main/java/com/algorithm/kmerge/FindKthSmallest.java)-->
- [Smallest Number Range](kwaymerge/SmallestRange.md) (Hard) <!-- [Java](../../src/main/java/com/algorithm/kmerge/SmallestRange.java) -->
- [Problem Challenge 1 - K Pairs with Largest Sums](kwaymerge/KPairsLargestSums.md) (Hard) <!-- [Java](../../src/main/java/com/algorithm/kmerge/KLargestPairs.java) -->

## 15. Pattern : 0/1 Knapsack (Dynamic Programming)
- [0/1 Knapsack](dp/Knapsack.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/dp/Knapsack.java) -->
- [Equal Subset Sum Partition](dp/EqualSubsetSumPartition.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/dynamicprogramming/CanPartition.java) -->
- [Subset Sum](dp/SubsetSum.md) (medium) <!-- [Java](../../src/main/java/com/algorithm/dp/SubsetSum.java) -->
- [Minimum Subset Sum Difference](dp/MinimumSubsetSumDifference.md) (hard) <!-- [Java](../../src/main/java/com/algorithm/dp/MinSubsetSumDifference.java) -->
- [Problem Challenge 1 - Count of Subset Sum](./dp/CountSubsets.md#count-of-subset-sum---hard) (hard) <!-- [Java](../../src/main/java/com/algorithm/dp/CountSubset.java) -->
- [Problem Challenge 2 - Target Sum](dp/TargetSum.md) (hard)

## 16. Pattern: Topological Sort (Graph)
- [Topological Sort](topologicalsort/TopologicalSort.md) (medium)
- [Tasks Scheduling](topologicalsort/CourseSchedule.md) (medium) 
- [Tasks Scheduling Order](topologicalsort/CourseScheduleOrder.md) (medium)
- [All Tasks Scheduling Orders](topologicalsort/AllCourseScheduleOrders.md) (hard)
- [Alien Dictionary](topologicalsort/AlienDictionary.md) (hard)
- [Problem Challenge 1 - Reconstructing a Sequence](topologicalsort/SequenceReconstruction.md) (hard) *
- [Problem Challenge 2 - Minimum Height Trees](topologicalsort/MinimumHeightTrees.md) (hard) *

## 17. Miscellaneous
- [Kth Smallest Number](miscellaneous/KthSmallestNumber.md) (hard)


# Reference
- [Python implementation](https://github.com/weiliping/Grokking-the-Coding-Interview-Patterns-for-Coding-Questions)
- [Find the Kth smallest element in an array](https://afteracademy.com/blog/kth-smallest-element-in-an-array)