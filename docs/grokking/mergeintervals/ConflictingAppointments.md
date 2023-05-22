# 252. Meeting Room - Easy

Given an array of intervals representing ‘N’ appointments, find out if a person can attend all the appointments.

##### Example 1:

```
Appointments: [[1,4], [2,5], [7,9]]
Output: false
Explanation: Since [1,4] and [2,5] overlap, a person cannot attend both of these appointments.
```

##### Example 2:

```
Appointments: [[6,7], [2,4], [8,12]]
Output: true
Explanation: None of the appointments overlap, therefore a person can attend all of them.
```

##### Example 3:

```
Appointments: [[4,5], [2,3], [3,6]]
Output: false
Explanation: Since [4,5] and [3,6] overlap, a person cannot attend both of these appointments.
```

#### Java Solution
```java
public class ConflictingAppointments {
    /**
     * 
     * @param intervals
     * @return
     */
    public static boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null) {
            return false;
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                return false;
            }
        }

        return true;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/mergeintervals/ConflictingAppointments.java)