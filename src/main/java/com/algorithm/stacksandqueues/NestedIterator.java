package com.algorithm.stacksandqueues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {
    /**
     * #341
     * https://leetcode-cn.com/problems/flatten-nested-list-iterator/
     * @param args
     */
    private Queue<Integer> queue;
    public NestedIterator(List<NestedInteger> nestedList) {
        queue = new LinkedList<>();
        dfs(nestedList);
    }

    void dfs(List<NestedInteger> nestedList) {
        for (NestedInteger it : nestedList) {
            if (it.isInteger()) {
                queue.offer(it.getInteger());
                continue;
            }
            dfs(it.getList());
        }
    }
    @Override
    public Integer next() {
        return queue.poll();
    }

    @Override
    public boolean hasNext() {
        return !queue.isEmpty();
    }
}
