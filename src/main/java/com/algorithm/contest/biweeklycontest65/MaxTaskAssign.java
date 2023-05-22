package com.algorithm.contest.biweeklycontest65;

import java.util.ArrayDeque;
import java.util.Arrays;

public class MaxTaskAssign {
    public static void main(String[] args) {
        MaxTaskAssign m = new MaxTaskAssign();
        int[] tasks1 = new int[] { 3, 2, 1 };
        int[] workers1 = new int[] { 0, 3, 3 };
        System.out.println(m.maxTaskAssign(tasks1, workers1, 1, 1));

        int[] tasks2 = new int[] { 5, 4 };
        int[] workers2 = new int[] { 0, 0, 0 };
        System.out.println(m.maxTaskAssign(tasks2, workers2, 1, 5));

        int[] tasks3 = new int[] { 10, 15, 30 };
        int[] workers3 = new int[] { 0, 10, 10, 10, 10 };
        System.out.println(m.maxTaskAssign(tasks3, workers3, 3, 10));

        int[] tasks = new int[] { 5, 9, 8, 5, 9 };
        int[] workers = new int[] { 1, 6, 4, 2, 6 };
        System.out.println(m.maxTaskAssign(tasks, workers, 1, 5));
        int[] tasks4 = new int[] { 8931, 7236, 4889, 6590, 9849, 4673, 6892, 1592, 1132, 3403, 1214, 3159, 4350, 5456,
                4998, 2235, 9016, 7766, 1979, 8420, 7056, 1056, 4493, 3899, 4344, 6707, 1474, 5846, 3535, 9493, 9015,
                7291, 2462, 3057, 8737, 2269, 5949, 4003, 9122, 8786, 5790, 1897, 8809, 5819, 1767, 6896, 2102, 2280,
                6778, 9635, 8006, 1631, 2822, 3792, 3103, 1721, 4738, 7867, 1820, 2252, 5896, 1751, 7783, 7045, 6460,
                9433, 5851, 7332, 5161, 7359, 1255, 9876, 1009, 8631, 4721, 2146, 7166, 9858, 6820, 5393, 9946, 1576,
                1807, 6362, 8644, 6088, 6274, 3787, 3589, 6646, 9108, 2538, 6912, 4629, 6178, 1859, 6004, 1118, 9436,
                5667, 2855, 6940, 1871, 3171, 1496, 5470, 4725, 6796, 9775, 1299, 5897, 9921 };
        int[] workers4 = new int[] { 3606, 4962, 3702, 4169, 3101, 563, 1551, 2906, 2061, 3382, 3340, 4599, 2826, 3894,
                1287, 4191, 1670, 2346, 3634, 4887, 3203, 2960, 2530, 4080, 674, 1031, 2387, 3611, 2222, 1796, 906,
                1191, 3473, 3551, 1383, 2029, 980, 1133, 688, 3881, 2423, 1053, 4056, 4567, 2640, 1419, 639, 4942, 1335,
                2111, 1139, 3596, 2675, 1114, 3171, 1428, 2950, 2414, 2471, 4177, 1552, 4452, 3154, 2907, 2148, 4044,
                942, 4058, 1537, 4063, 2580, 1665, 3486, 1653, 2841, 4682, 3815, 2174, 4530, 3807, 1291, 2624, 907,
                1809, 3723, 4917, 1314, 1682, 4740, 2334, 2743, 2318, 1413, 996, 975, 3937, 3766, 4597, 760, 1314, 1573,
                3974, 3008, 901, 2319, 3958, 3069, 2808, 4087, 4920, 4020, 662, 2279, 1831, 2196, 1083, 767, 1682, 2726,
                3126, 2549, 4788, 3323, 906, 4964, 1641, 2203, 3732, 2553, 4481, 3969, 3726, 4101, 3429, 3897, 3154,
                2356, 3096, 4902, 3719, 837, 685, 4471, 4306, 1888, 804, 4175, 2480, 777, 4396, 1896, 1125, 2471, 1362,
                4940, 1803, 4903, 2248, 3542, 1816, 895, 4731, 4337, 2482, 1656, 4312, 1088, 2499, 4558, 1322, 973,
                1916, 1902, 1600, 2429, 1134, 4297, 827, 1459, 1270, 1102, 997, 1326, 4424, 4114, 1134, 2221, 1376,
                2143, 1409, 3555, 1849, 4843, 2751, 3093, 2048, 4604, 4922, 2210, 4069, 2140, 4870, 4153, 4327, 4976,
                2954, 4157, 504, 3321, 523 };
        System.out.println(m.maxTaskAssign(tasks4, workers4, 66, 9620));
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        int m = tasks.length, n = workers.length;
        int len = Math.min(m, n);
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int i = 1, j = len, ans = 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (isCheckStack(tasks, workers, pills, strength, mid, n)) {
                ans = mid;
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return ans;
    }

    boolean isCheckStack(int[] tasks, int[] workers, int pills, int strength, int k, int n) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = n - k; i < n; i++) {
            queue.offer(workers[i]);
        }
        for (int j = k - 1; j >= 0; j--) {
            if (queue.peekLast() >= tasks[j]) {
                queue.pollLast();
                continue;
            }
            if (pills == 0) {
                return false;
            }
            int v = tasks[j] - strength;
            Integer f = queue.stream().filter(a -> a >= v).findFirst().orElse(null);
            if (f == null) {
                return false;
            }
            pills--;
            queue.remove(f);
        }
        return true;
    }

    boolean isCheck(int[] tasks, int[] workers, int pills, int strength, int k, int n) {
        boolean[] visited = new boolean[k];
        int s = n - 1, e = n - k;
        for (int j = k - 1; j >= 0; j--) {
            while (visited[s - n + k]) {
                s--;
            }
            if (s < e) {
                return false;
            }
            if (workers[s] >= tasks[j]) {
                visited[s - n + k] = true;
                s--;
                continue;
            }
            if (pills == 0 || tasks[j] > workers[s] + strength) {
                return false;
            }
            int s1 = s;
            while (s1 > e && tasks[j] <= workers[s1] + strength) {
                s1--;
            }
            while (visited[s1 - n + k]) {
                s1++;
            }
            if (s1 < e || s1 > s) {
                return false;
            }
            visited[s1 - n + k] = true;
            pills--;
        }
        return true;
    }
}
