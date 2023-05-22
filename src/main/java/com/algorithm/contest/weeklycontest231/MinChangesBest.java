package com.algorithm.contest.weeklycontest231;

import java.util.Arrays;

public class MinChangesBest {
    static class VC implements Comparable<VC> {
        final int value;
        final int index;
        int count;

        VC(int index, int v) {
            this.index = index;
            this.value = v;
        }

        @Override
        public int compareTo(VC o) {
            return o.count - this.count;
        }

        @Override
        public String toString() {
            return value + ":" + count;
        }
    }

    static class Node implements Comparable<Node> {
        final int index;
        VC[] vs;
        int size;
        int count;
        int min_change;
        int min_change_all;
        int[] cs;

        Node(VC[] vcs, int[] nums, int index, int k) {
            this.index = index;
            vs = new VC[(nums.length - index - 1) / k + 1];
            size = 0;
            for (int i = index; i < nums.length; i += k) {
                int v = nums[i];
                VC vc = vcs[v];
                if (vc == null || vc.index != index) {
                    vc = vcs[v] = new VC(index, v);
                }
                if (vc.count++ == 0)
                    vs[size++] = vc;
                count++;
            }
            Arrays.sort(vs, 0, size);
            this.min_change = count - vs[0].count;
        }

        void buildcs() {
            int maxv = 0;
            for (int i = 0; i < size; i++) {
                maxv = Math.max(maxv, vs[i].value);
            }
            this.cs = new int[maxv + 1];
            for (int i = 0; i < size; i++) {
                this.cs[vs[i].value] = vs[i].count;
            }
        }

        int cs(int value) {
            return value < cs.length ? cs[value] : 0;
        }

        @Override
        public int compareTo(Node o) {
            int r = o.min_change - this.min_change;
            if (r == 0)
                r = this.count - o.count;
            return r;
        }

    }

    /**
     * 这里使用BFS比DP的计算量少很多。首先按照每行最少替换成本降序排列，然后从最小成本开始替换，每次替换也首先考虑当前行的最小成本，按照DFS思路构建替换路径，计算每个路径的替换成本。
     * 每个路径的替换成本都与最小成本数进行比较，同时将其中的最小再作为比较标准，最小成本默认是数列的长度。
     * 这里的剪枝做的很巧妙，min_change_all表示余下未替换步骤采用最优替换的最小替换和，再次基础上加上当前已经执行的替换数，如果比min_change大，就放弃后面的计算。min_change_all的设计很巧妙。
     * 和DP相比，它按照每行的最优选择依次DFS搜索可能的替换路径，再搜索到最后一层时，判断该数值作为替换的成本（因此存在或不存在都考虑到了），不用像DP那样计算所有可能的替换值。
     */
    static int dfs(Node[] nodes, int index, int v, int changes, int min_change) {
        Node node = nodes[index];
        if (index == 0) {
            changes += node.count - node.cs(v);
            if (changes < min_change) {
                min_change = changes;
            }
            return min_change;
        }
        //优秀的剪枝判断
        if (changes + node.min_change_all >= min_change) {
            return min_change;
        }
        for (int i = 0; i < node.size; i++) {
            VC vc = node.vs[i];
            min_change = dfs(nodes, index - 1, v ^ vc.value, changes + node.count - vc.count, min_change);
        }
        return min_change;
    }

    public int minChanges(int[] nums, int k) {
        final int N = nums.length;
        int res = 0;
        if (k == 1) {
            for (int v : nums) {
                if (v != 0) {
                    res++;
                }
            }
            return res;
        }
        if (k >= N) {
            for (int v : nums) {
                res ^= v;
            }
            res = res == 0 ? 0 : 1;
            return res;
        }
        Node[] nodes = new Node[k];
        int maxv = 0;
        for (int v : nums) {
            maxv = Math.max(maxv, v);
        }
        VC[] vcs = new VC[maxv + 1];
        for (int i = 0; i < k; i++) {
            nodes[i] = new Node(vcs, nums, i, k);
        }
        Arrays.sort(nodes);

        int s = 0;
        for (Node node : nodes) {
            s += node.min_change;
            node.min_change_all = s;
        }
        nodes[0].buildcs();
        res = dfs(nodes, k - 1, 0, 0, N);
        return res;
    }
}
