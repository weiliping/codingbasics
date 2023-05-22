Write an algorithm to determine if a number ```n``` is happy.

A <b> happy number </b> is a number defined by the following process:

- Starting with any positive integer, replace the number by the sum of the squares of its digits.
- Repeat the process until the number equals 1 (where it will stay), or it <b>loops endlessly in a cycle</b> which does not include 1.
- Those numbers for which this process <b>ends in 1</b> are happy.

Return true if n is a happy number, and false if not.

##### Example 1:
```
Input: n = 19
Output: true
Explanation:
12 + 92 = 82
82 + 22 = 68
62 + 82 = 100
12 + 02 + 02 = 1
```

##### Example 2:
```
Input: n = 2
Output: false
```
##### Constraints:

- 1 <= n <= 2<sup>31</sup> - 1 

#### Java Solution
```java
public class HappyNumber {

    public static boolean isHappy(int n) {
        Set<Integer> s = new HashSet<>();
        while (true) {
            int t = trans(n);
            if (t == 1) {
                return true;
            }
            if (s.contains(t)) {
                return false;
            }
            s.add(t);
            n = t;
        }
    }

    static int trans(int n) {
        int s = 0;
        while (n > 0) {
            int t = n % 10;
            s += t * t;
            n = n / 10;
        }
        return s;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/math/HappyNumber.java)

