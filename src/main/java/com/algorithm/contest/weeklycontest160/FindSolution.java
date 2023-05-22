package com.algorithm.contest.weeklycontest160;

import java.util.ArrayList;
import java.util.List;

public class FindSolution {

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x + y;
        }
    }
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 1; i <= 1000; i++) {
            if (customfunction.f(i, 1) > z) {
                break;
            }
            int l = 1, r = z;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                int t = customfunction.f(i, mid);
                if (t == z) {
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(mid);
                    res.add(list);
                    break;
                }
                if (t > z) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return res;
    }
}
