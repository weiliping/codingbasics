# 480. Sliding Window Median - Hard

Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

Examples:
```[2,3,4]```, the median is 3

```[2,3]```, the median is ```(2 + 3) / 2 = 2.5```

Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Your job is to output the median array for each window in the original array.

For example,
Given nums = ```[1,3,-1,-3,5,3,6,7]```, and k = 3.

```
Window position                Median
---------------               -----
[1  3  -1] -3  5  3  6  7       1
 1 [3  -1  -3] 5  3  6  7       -1
 1  3 [-1  -3  5] 3  6  7       -1
 1  3  -1 [-3  5  3] 6  7       3
 1  3  -1  -3 [5  3  6] 7       5
 1  3  -1  -3  5 [3  6  7]      6
```
Therefore, return the median sliding window as ```[1,-1,-1,3,5,6]```.


##### Note:
You may assume ```k``` is always valid, ie: ```k``` is always smaller than input array's size for non-empty array.
Answers within ```10^-5``` of the actual value will be accepted as correct.

#### Java Solution
```java
public class MedianSlidingWindow {

    public static double[] medianSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length < k) {
            return new double[0];
        }

        int n = nums.length;
        double[] res = new double[n - k + 1];
        PriorityQueue<Integer> right = new PriorityQueue<>();
        PriorityQueue<Integer> left = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i2.compareTo(i1);
            }
        });
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                removeNum(left, right, nums[i - k]);
            }
            addNum(left, right, nums[i]);
            if (i >= k - 1) {
                res[i - k + 1] = getMedian(left, right);
            }
        }
        return res;
    }

    private static void removeNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        if (num > getMedian(left, right)) {
            right.remove(num);
        } else {
            left.remove(num);
        }
        balanceQueues(left, right);
    }

    private static void addNum(PriorityQueue<Integer> left, PriorityQueue<Integer> right, int num) {
        if (num > getMedian(left, right)) {
            right.offer(num);
        } else {
            left.offer(num);
        }
        balanceQueues(left, right);
    }

    private static void balanceQueues(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.size() < right.size()) {
            left.offer(right.poll());
        } else if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        }
    }

    private static double getMedian(PriorityQueue<Integer> left, PriorityQueue<Integer> right) {
        if (left.isEmpty() && right.isEmpty()) {
            return 0.0;
        }
        if (left.size() == right.size()) {
            return ((double) left.peek() + (double) right.peek()) * 0.5;
        }
        return (double) left.peek();
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/slidingwindow/MedianSlidingWindow.java)