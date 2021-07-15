package com.algorithm.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EmployeeFreeTime {
    /**
     * #759
     *
     * @param args
     */
    public static void main(String[] args) {
        List<List<Interval>> avails = new ArrayList<>();
        List<Interval> sub = new ArrayList<>();
        sub.add(new Interval(1,3));
        sub.add(new Interval(6,7));
        avails.add(sub);
        List<Interval> sub2 = new ArrayList<>();
        sub2.add(new Interval(2,4));
        avails.add(sub2);
        List<Interval> sub3 = new ArrayList<>();
        sub3.add(new Interval(2,5));
        sub3.add(new Interval(9,12));
        avails.add(sub3);
        List<Interval> res = employeeFreeTime(avails);
        System.out.println(Arrays.toString(res.toArray()));
    }

    /**
     * #759
     *
     * @param avails
     * @return
     */
    public static List<Interval> employeeFreeTime(List<List<Interval>> avails) {
        List<Interval> result = new ArrayList<>();
        List<Interval> timeLine = new ArrayList<>();
        avails.forEach(e -> timeLine.addAll(e));
        Collections.sort(timeLine, ((a, b) -> a.start - b.start));

        Interval temp = timeLine.get(0);
        for (Interval each : timeLine) {
            if (temp.end < each.start) {
                result.add(new Interval(temp.end, each.start));
                temp = each;
            } else {
                temp = temp.end < each.end ? each : temp;
            }
        }
        return result;
    }
}
