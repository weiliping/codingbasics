package com.algorithm.selfpractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Test {
    public static Set<Integer>[] FACTORS = new HashSet[100001];
    static {
        for (int i = 1; i < 100001; i++) {
            FACTORS[i] = primeFactor(i);
        }
    }
    public static Set<Integer> primeFactor(int num) {
        List<Integer> primeNums = primeNums(num);
        Set<Integer> res = new HashSet<>();
        perHelper(primeNums, 0, 1, res);
        return res;    
    }

    public static List<Integer> primeNums(int num) {
        List<Integer> factors = new ArrayList<>();
        for (int i = 2; i * i <= num; i++) {
            while (num % i == 0) {
                factors.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            factors.add(num);
        }
        return factors;
    }

    public static void perHelper(List<Integer> factors, int i, int v, Set<Integer> res) {
        if (i == factors.size()) {
            res.add(v);
            return;
        }
        perHelper(factors, i + 1, v, res);
        perHelper(factors, i + 1, v * factors.get(i), res);
    }
    
    public int[] assignElements(int[] groups, int[] elements) {
        int n = groups.length;
        Map<Integer, Integer> elMap = new HashMap<>();
        for (int i = 0; i < elements.length; i++) {
            if (!elMap.containsKey(elements[i])) {
                elMap.put(elements[i], i);
            } else {
                elements[i] = -1;
            }
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Set<Integer> factors = FACTORS[groups[i]];
            for (int factor : factors) {
                if (!elMap.containsKey(factor)) {
                    continue;
                }
                if (!map.containsKey(factor)) {
                    map.put(factor, new HashSet<>());
                }
                map.get(factor).add(i);
            }
        }

        int[] res = new int[n];
        Arrays.fill(res, -1);
        for (int j = 0; j < elements.length; j++) {
            int el = elements[j];
            if (el == -1) {
                continue;
            }
            if (!map.containsKey(el)) {
                continue;
            }
            Set<Integer> set = map.get(el);
            for (int i : set) {
                if (res[i] == -1) {
                    res[i] = j;
                }
            }
        }
       
        return res;    
    }
    public static void main(String[] args) {
        // int[] elements = new int[10001];
        // int[] groups = new int[]{14811,80318,2705,7147,72054,14372,80662,35593,45012,5477,24597,31909,7903,19730,69632,87874,85780,62806,87126,5246,57062,28301,23995,77451,96067,85731,80640,99730,78229,78842,35581,2523,70817,97620,41314,75444,78341,18637,65750,20429,20060,63702,49582,50447,9719,36082,7106,4015,34052,84590,4000,56717,66688,55811,66684,58039,58301,98094,30086,27475,88854,37973,95622,45713,53074,16374,11038,88987,7307,38675,76576,29319,35654,73811,28876,65706,55606,32669,11827,20980,69252,27762,11798,20966,69664,91697,37180,48687,58309,9936,31852,1973,33640,66654,25008,376,34208,50199,34389,16322,62495,88600,3067,8393,80904,74716,2866,20993,61372,79537,76367,6574,75345,63640,55874,20283,32372,97331,24161,85506};

        // Arrays.fill(elements, 1);
        // Test t = new Test();
        // System.out.println(Arrays.toString(t.assignElements(groups, elements)));       
        // System.out.println(Integer.MAX_VALUE > 1000000000000l);
        // System.out.println(0 + ((2 - 0)>>1));
        // System.out.println(maxSubstringLength("gnyww", 4));
        // System.out.println(maxSubstringLength("uqjxfyrgpnrrjyfxqvtpvyipznvtyuuzrtaxvzitgbqpjxzmixyabgbzfuvuvvaunyuuxbrjuuxtvnbygptxnvaaxumgxqqmtbzxnniiubgzyumzqfixuuuqtrraqjfnymrjygtuzrrrxutrmnazafzqttaanfyzvfnfrmyxzritbuaftygfqtaumuxujaqrpbbbyxmbpjqrtpuggyyityfmmrubaygoehkdowsoeehklwolokdcckddwloeklcodecslcsdhwwlheclldewwksdkksooecceowheddhechshlwokeohwoedkhoodehhewocewheocscwdllsocshkhswodchckdkeeeeoholeleddkwsehokhwlooksohdkwhwhkwscecdddcdkdsskdhsllckedseeehkokdoldoloelccwkedelddsccewldkohelslolhdhoksohkdkhccdhsedsldckoodhcseherbnrttirutqftuxvfmiggxuaazppxjrrxibzzaxzznzvgbjmrpuixmgbfqpzztmjzgqbmfvazyyftmguxxpxyfvvfabbiiyyjanaqvfvpfuyqipgnbuguptpuvvxpnggqir", 1));
        // System.out.println(hasSameDigits("3902"));
        // int[][] grid = new int[][] {{5,3,7}, {8,2,6}};
        // int[] limits = new int[]{2, 2};
        // int k = 3;
        int[] original = {1, 2, 3, 4};
        int[][] bounds = {{1,10}, {2,9}, {3, 8}, {4, 7}};
        int res = countArrays(original, bounds);
        System.out.println(res);
    }

    public static int countArrays(int[] original, int[][] bounds) {
        int n = original.length;
        int preL = bounds[0][0], preR = bounds[0][1];
        for (int i = 1; i < n; i++) {
            int diff = original[i] - original[i - 1];
            preL = Math.max(bounds[i][0], preL + diff);
            preR = Math.min(bounds[i][1], preR + diff);
            if (preL > preR) {
                return 0;
            }
        }
        return preR - preL + 1;
    } 

    public static long maxSum(int[][] grid, int[] limits, int k) {
        if (k == 0) {
            return 0l;
        }
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            int[] row = grid[i];
            Arrays.sort(row);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > n - limits[i] - 1; j--) {
                if (pq.size() < k) {
                    pq.offer(grid[i][j]);
                } else if (grid[i][j] > pq.peek()) {
                    pq.poll();
                    pq.offer(grid[i][j]);
                }
            }
        }
        long s = 0;
        while (pq.size() > 0) {
            s += pq.poll();
        }
        return s;
    }

    public static boolean hasSameDigits(String s) {
        List<Integer> nums = new ArrayList<>();
        for (char c : s.toCharArray()) {
            nums.add(c - '0');
        }
        return helper(nums);
    }

    public static boolean helper(List<Integer> nums) {
        if (nums.size() == 2) {
            return nums.get(0) == nums.get(1);
        }
        List<Integer> l = new ArrayList<>();
        for (int i = 0; i < nums.size() - 1; i++) {
            l.add((nums.get(i) + nums.get(i + 1)) % 10);
        }
        return helper(l);
    }

    public static boolean maxSubstringLength(String s, int k) {
        if (k == 0) {
            return true;
        }
        int[][] cnts = new int[26][3];
        for (int i = 0; i < 26; i++) {
            cnts[i][0] = -1;
            cnts[i][1] = -1;
        }
        char[] chrs = s.toCharArray();
        int n = chrs.length;
        for (int i = 0; i < n; i++) {
            int idx = chrs[i] - 'a';
            if (cnts[idx][0] == -1) {
                cnts[idx][0] = i;
            }
            cnts[idx][1] = i;
            cnts[idx][2]++;
        }
        Arrays.sort(cnts, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        int c = 0;
        LinkedList<int[]> list = new LinkedList<>();
        for (int i = 0; i < 26; i++) {
            if (cnts[i][0] == -1 || cnts[i][2] == 0) {
                continue;
            }
            list.add(cnts[i]);
            while (list.size() > 1 && list.get(list.size() - 2)[1] > list.getLast()[0]) {
                int[] last = list.pollLast();
                int[] sec = list.pollLast();
                sec[0] = Math.min(sec[0], last[0]);
                sec[1] = Math.max(sec[1], last[1]);
                sec[2] += last[2];
                list.add(sec);
            }
            int[] l = list.getLast();
            if (l[1] - l[0] + 1 == l[2]) {
                int[] a = list.pollLast();
                if (a[2] != n) {
                    c++;
                }    
            }
        }
        return c >= k;
    }
}
