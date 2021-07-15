package com.algorithm.contest.weeklycontest215;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderedStream {
    public static void main(String[] args) {
        OrderedStream os= new OrderedStream(5);
        System.out.println(Arrays.toString(os.insert(3, "ccccc").toArray()));; // 插入 (3, "ccccc")，返回 []
        System.out.println(Arrays.toString(os.insert(1, "aaaaa").toArray())); // 插入 (1, "aaaaa")，返回 ["aaaaa"]
        System.out.println(Arrays.toString(os.insert(2, "bbbbb").toArray())); // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
        System.out.println(Arrays.toString(os.insert(5, "eeeee").toArray())); // 插入 (5, "eeeee")，返回 []
        System.out.println(Arrays.toString(os.insert(4, "ddddd").toArray())); // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]
    }

    String[] strs;
    int ptr;
    int n;
    public OrderedStream(int n) {
        this.strs = new String[n];
        this.ptr = 1;
        this.n = n;
    }

    public List<String> insert(int idKey, String value) {
        strs[idKey - 1] = value;
        List<String> res = new ArrayList<>();
        if (ptr == idKey) {
            while (ptr <= n && strs[ptr - 1] != null) {
                res.add(strs[ptr - 1]);
                ptr++;
            }
        }
        return res;
    }
}
