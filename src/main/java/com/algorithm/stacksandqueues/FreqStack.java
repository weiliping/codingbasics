package com.algorithm.stacksandqueues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class FreqStack {
    /**
     * #895
     * https://leetcode.com/problems/maximum-frequency-stack/
     * @param args
     */
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5); // The stack is [5]
        freqStack.push(7); // The stack is [5,7]
        freqStack.push(5); // The stack is [5,7,5]
        freqStack.push(7); // The stack is [5,7,5,7]
        freqStack.push(4); // The stack is [5,7,5,7,4]
        freqStack.push(5); // The stack is [5,7,5,7,4,5]
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,5,7,4].
        freqStack.pop();   // return 7, as 5 and 7 is the most frequent, but 7 is closest to the top. The stack becomes [5,7,5,4].
        freqStack.pop();   // return 5, as 5 is the most frequent. The stack becomes [5,7,4].
        freqStack.pop();   // return 4, as 4, 5 and 7 is the most frequent, but 4 is closest to the top. The stack becomes [5,7].

        FreqStack freqStack2 = new FreqStack();
        freqStack2.push(1);
        freqStack2.push(1);
        freqStack2.push(1);
        freqStack2.pop();
        freqStack2.pop();
        freqStack2.push(2);
        freqStack2.push(2);
        freqStack2.push(1);

        freqStack2.pop();
        freqStack2.pop();
        freqStack2.pop();
        //[null,null,null,null,null,1,1,null,null,null,2,1,2]
    }

    int index;
    Map<Integer, Pair> frequences;
    PriorityQueue<Pair> queue;
    public FreqStack() {
        frequences = new HashMap<>();
        queue = new PriorityQueue<>((a, b) -> a.f == b.f ? b.ind - a.ind : b.f - a.f );
        index = 0;
    }

    public void push(int val) {
        index++;
        if (frequences.containsKey(val)) {
            Pair p = frequences.get(val);
            queue.remove(p);
            p.inds.add(index);
            Pair np = new Pair(val, p.f + 1, p.inds);
            frequences.put(val, np);
            queue.offer(np);
            return;
        }
        Pair p = new Pair(val, 1, index);
        frequences.put(val, p);
        queue.offer(p);
    }

    public int pop() {
        Pair p = queue.poll();
        p.f--;
        p.inds.remove(p.inds.size() - 1);
        if (p.f > 0) {
            p.ind = p.inds.get(p.inds.size() - 1);
            queue.offer(p);
        }
        System.out.println(p.k);
        return p.k;
    }

    class Pair {
        int k;
        int f;
        int ind;
        List<Integer> inds = new ArrayList<>();
        public Pair(int key, int freq, int index) {
            k = key;
            f = freq;
            inds.add(index);
            ind = index;
        }

        public Pair(int key, int freq, List<Integer> indexes) {
            k = key;
            f = freq;
            inds = indexes;
            ind = index;
        }
    }
}
