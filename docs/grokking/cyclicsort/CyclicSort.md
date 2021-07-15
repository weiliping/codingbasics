# Cyclic Sort - Easy

We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’ based on their creation sequence. 

This means that the object with sequence number ‘3’ was created just before the object with sequence number ‘4’.

Write a function to sort the objects in-place on their creation sequence number in <b>O(n)</b> and without any <b>extra space</b>. 

For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.

##### Example 1:

```
Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]
```

##### Example 2:

```
Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]
```

##### Example 3:

```
Input: [1, 5, 6, 4, 3, 2]
Output: [1, 2, 3, 4, 5, 6]
```

#### Java Solution
```java
public class CyclicSort {

    public static void cyclicSort(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            while (nums[i] > 0 && nums[i] <= n && nums[nums[i] - 1] != nums[i]) {
                int tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
    }
}

```

#### [Java Source Code](../../../src/main/java/com/algorithm/cyclicsort/CyclicSort.java)