package com.algorithm.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
    /**
     * #380
     * https://leetcode-cn.com/problems/insert-delete-getrandom-o1/submissions/
     *
     */
    public static void main(String[] args) {
        RandomizedSet randomSet = new RandomizedSet();

        randomSet.insert(1);
        randomSet.remove(2);
        randomSet.insert(2);
        randomSet.getRandom();
        randomSet.remove(1);
        randomSet.insert(2);
        randomSet.getRandom();
    }

    private List<Integer> nums;
    private Map<Integer, Integer> map;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        nums = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (nums.contains(val)) {
            return false;
        }
        map.put(val, nums.size());
        nums.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!nums.contains(val)) {
            return false;
        }
        int ind = map.get(val);
        if (ind < nums.size() - 1) {
            nums.set(ind, nums.get(nums.size() - 1));
            map.put(nums.get(ind), ind);
        }
        nums.remove(nums.size() - 1);
        map.remove(val);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
