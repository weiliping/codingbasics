package com.algorithm.contest.weeklycontest163;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaxSumDivThree {

    public static void main(String[] args) {
        MaxSumDivThree m = new MaxSumDivThree();
        System.out.println(m.maxSumDivThree(new int[]{3,6,5,1,8}));
        System.out.println(m.maxSumDivThree(new int[]{4}));
        System.out.println(m.maxSumDivThree(new int[]{1,2,3,4,4}));
        System.out.println(m.maxSumDivThree(new int[]{5,2,2,2}));
        System.out.println(m.maxSumDivThree(new int[]{1,1,5,4,7}));
        System.out.println(m.maxSumDivThree(new int[]{2,14,15,17,6,18,12,18,15,4}));
        int[] nums = new int[]{366,809,6,792,822,181,210,588,344,618,341,410,121,864,191,749,637,169,123,472,358,908,235,914,322,946,738,754,908,272,267,326,587,267,803,281,586,707,94,627,724,469,568,57,103,984,787,552,14,545,866,494,263,157,479,823,835,100,495,773,729,921,348,871,91,386,183,979,716,806,639,290,612,322,289,910,484,300,195,546,499,213,8,623,490,473,603,721,793,418,551,331,598,670,960,483,154,317,834,352};
        System.out.println(m.maxSumDivThree(nums));
    }
    static final int MAX = 100000;
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int k = sum % 3;
        if (k == 0) {
            return sum;
        }
        int g = 3 - k;
        int minK = MAX, minG1 = MAX, minG2 = MAX;
        for (int num : nums) {
            int l = num % 3;
            if (l == k) {
                if (minK > num) {
                    minK = num;
                }
                continue;
            }
            if (g == l) {
                if (minG1 > num) {
                    minG2 = minG1;
                    minG1 = num;
                } else if (minG2 > num){
                    minG2 = num;
                }
            }
        }
        int one = Math.min(minK, minG1 + minG2);
        if (one == MAX) {
            return 0;
        }
        return sum - one;
    }

    public int maxSumDivThreeI(int[] nums) {
        int ans = 0;
        PriorityQueue<Integer> queue1 = new PriorityQueue<>((a, b) -> b - a);
        PriorityQueue<Integer> queue2 = new PriorityQueue<>((a, b) -> b - a);

        for (int num : nums) {
            int l = num % 3;
            if (l == 0) {
                ans += num;
                continue;
            }
            int t = num / 3;
            if (l == 1) {
                queue1.offer(t);
                continue;
            }
            queue2.offer(t);
        }
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int[] q1 = new int[3], q2 = new int[3];
            Arrays.fill(q1, -1);
            Arrays.fill(q2, -1);
            int i1 = 0;
            while (!queue1.isEmpty()) {
                q1[i1++] = queue1.poll();
                if (i1 == 3) {
                    break;
                }
            }
            int i2 = 0;
            while (!queue2.isEmpty()) {
                q2[i2++] = queue2.poll();
                if (i2 == 3) {
                    break;
                }
            }

            ans += maxVal(q1, q2, i1, i2);

            for (int i = 0; i < 3; i++) {
                if (q1[i] != -1) {
                    queue1.offer(q1[i]);
                }
                if (q2[i] != -1) {
                    queue2.offer(q2[i]);
                }
            }
        }
        while (!queue1.isEmpty() && queue1.size() >= 3) {
            ans += 3 * (queue1.poll() + queue1.poll() + queue1.poll()) + 3;
        }
        while (!queue2.isEmpty() && queue2.size() >= 3) {
            ans += 3 * (queue2.poll() + queue2.poll() + queue2.poll()) + 6;
        }
        return ans;
    }

    int maxVal(int[] q1, int[] q2, int i1, int i2) {
        int num1 = 0;
        if (i1 == 3) {
            num1 += 3 * (q1[0] + q1[1] + q1[2]) + 3;
        }
        int num2 = 0;
        if (i2 == 3) {
            num2 += 3 * (q2[0] + q2[1] + q2[2]) + 6;
        }

        int num3 = 3 * (q1[0] + q2[0]) + 3;

        if (num1 > num2) {
            if (num1 > num3) {
                q1[0] = -1;
                q1[1] = -1;
                q1[2] = -1;
                return num1;
            } else {
                q1[0] = -1;
                q2[0] = -1;
                return num3;
            }
        } else {
            if (num2 > num3) {
                q2[0] = -1;
                q2[1] = -1;
                q2[2] = -1;
                return num2;
            } else {
                q1[0] = -1;
                q2[0] = -1;
                return num3;
            }
        }
    }

}
