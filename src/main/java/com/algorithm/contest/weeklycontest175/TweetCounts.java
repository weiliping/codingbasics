package com.algorithm.contest.weeklycontest175;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TweetCounts {

    public static void main(String[] args) {
        TweetCounts t = new TweetCounts();
//        t.recordTweet("tweet3", 0);
//        t.recordTweet("tweet3", 60);
//        t.recordTweet("tweet3", 10);                             // "tweet3" 发布推文的时间分别是 0, 10 和 60 。
//        // 返回 [2]。统计频率是每分钟（60 秒），因此只有一个有效时间间隔 [0,60> - > 2 条推文。
//        String f1 = "minute", tn1 = "tweet3";
//        int st1 = 0, et1 = 60;
//        System.out.println(Arrays.toString(t.getTweetCountsPerFrequency(f1, tn1, st1, et1).toArray()));
//        // 返回 [2,1]。统计频率是每分钟（60 秒），因此有两个有效时间间隔 1) [0,60> - > 2 条推文，和 2) [60,61> - > 1 条推文。
//        String f2 = "minute", tn2 = "tweet3";
//        int st2 = 0, et2 = 60;
//        System.out.println(Arrays.toString(t.getTweetCountsPerFrequency(f2, tn2, st2, et2).toArray()));
//        t.recordTweet("tweet3", 120); // "tweet3" 发布推文的时间分别是 0, 10, 60 和 120 。
//        // 返回 [4]。统计频率是每小时（3600 秒），因此只有一个有效时间间隔 [0,211> - > 4 条推文。
//        String f3 = "hour", tn3 = "tweet3";
//        int st3 = 0, et3 = 210;
//        System.out.println(Arrays.toString(t.getTweetCountsPerFrequency(f3, tn3, st3, et3).toArray()));

//        t.recordTweet("tweet0", 33);
//        t.recordTweet("tweet1", 89);
//        t.recordTweet("tweet2", 99);
//        t.recordTweet("tweet3", 53);
//        t.recordTweet("tweet4", 3);
//        String f4 = "hour", tn4 = "tweet0";
//        int st4 = 89, et4 = 3045;
//        List<Integer> res = t.getTweetCountsPerFrequency(f4, tn4, st4, et4);
//        System.out.println(Arrays.toString(res.toArray()));

//        t.recordTweet("tweet0", 78);
//        t.recordTweet("tweet1", 7);
//        t.recordTweet("tweet2", 61);
//        t.recordTweet("tweet3", 0);
//        t.recordTweet("tweet4", 20);
//        String f5 = "minute", tn5 = "tweet2";
//        int st5 = 78, et5 = 5374;
//        List<Integer> res = t.getTweetCountsPerFrequency(f5, tn5, st5, et5);
//        System.out.println(Arrays.toString(res.toArray()));
        t.recordTweet("tweet0", 43);
        t.recordTweet("tweet1", 65);
        t.recordTweet("tweet2", 39);
        t.recordTweet("tweet3", 16);
        t.recordTweet("tweet4", 82);
        t.recordTweet("tweet4", 25);
        t.recordTweet("tweet3", 66);
        String f6 = "hour", tn6 = "tweet3";
        int st6 = 43, et6 = 1838;
        List<Integer> res = t.getTweetCountsPerFrequency(f6, tn6, st6, et6);
        System.out.println(Arrays.toString(res.toArray()));
    }

    static Map<String, Integer> deltas = new HashMap<>();
    static {
        deltas.put("minute", 60);
        deltas.put("hour", 3600);
        deltas.put("day", 86400);
    }
    Map<String, LinkedList<Integer>> mp;
    public TweetCounts() {
        mp = new HashMap<>();
    }

    public static void add(LinkedList<Integer> link, int val) {
        if (link.isEmpty()) {
            link.add(val);
            return;
        }
        int i = 0;
        for (; i < link.size(); i++) {
            if (link.get(i) > val) {
                break;
            }
        }
        link.add(i, val);
    }

    public void recordTweet(String tweetName, int time) {
        LinkedList<Integer> q = mp.getOrDefault(tweetName, new LinkedList<>());
        add(q, time);
        mp.put(tweetName, q);
    }

    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        int delta = deltas.get(freq);

        List<Integer> res = new ArrayList<>();
        LinkedList<Integer> q = mp.get(tweetName);
        int n = q.size();
        Integer[] times = q.toArray(new Integer[n]);
        int sTime = startTime;
        int nextTime = sTime + delta;
        while (sTime <= endTime) {
            int sInd = binarySearchGt(times, sTime);
            if (nextTime > endTime + 1) {
                int eInd = binarySearchLt(times, endTime + 1);
                if (eInd == -1 || sInd == -1) {
                    res.add(0);
                } else {
                    res.add(eInd - sInd + 1);
                }
                break;
            }
            int eInd = binarySearchLt(times, nextTime);
            if (eInd == -1 || sInd == -1) {
                res.add(0);
            } else {
                res.add(eInd - sInd + 1);
            }
            sTime = nextTime;
            nextTime += delta;
        }
        return res;
    }

    private static int binarySearchGt(Integer[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == val) {
                return mid;
            }

            if (nums[mid] > val) {
                if (mid == 0) {
                    return mid;
                }
                if (nums[mid - 1] < val) {
                    return mid;
                }
                j = mid - 1;
            } else {
                if (mid == nums.length - 1) {
                    return -1;
                }
                if (nums[mid + 1] > val) {
                    return mid + 1;
                }
                i = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchLt(Integer[] nums, int val) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (nums[mid] == val) {
                if (mid == 0) {
                    return -1;
                }
                j = mid - 1;
            }

            if (nums[mid] < val) {
                if (mid == nums.length - 1) {
                    return mid;
                }
                if (nums[mid + 1] >= val) {
                    return mid;
                }
                i = mid + 1;
            } else {
                if (mid == 0) {
                    return -1;
                }
                if (nums[mid - 1] < val) {
                    return mid - 1;
                }
                j = mid - 1;
            }
        }
        return -1;
    }
}
