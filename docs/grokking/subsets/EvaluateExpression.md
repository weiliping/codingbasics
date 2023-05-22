# Evaluate Expression -Hard

Given an expression containing digits and operations (+, -, *), find all ```possible``` ways in which the expression can be evaluated by grouping the numbers and operators using parentheses.

##### Example 1:
```
Input: "1+2*3"
Output: 7, 9
Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
```

##### Example 2:
```
Input: "2*3-4-5"
Output: 8, -12, 7, -7, -3 
Explanation: 2*(3-(4-5)) => 8, 2*(3-4-5) => -12, 2*3-(4-5) => 7, 2*(3-4)-5 => -7, (2*3)-4-5 => -3
```

#### Java Solution
```java
public class EvaluateExpression {
    public static List<Integer> evaluateExpression(String evalStr) {
        List<Integer> res = new ArrayList<>();
        if (!evalStr.contains("-") && !evalStr.contains("+") && !evalStr.contains("*")){
            res.add(Integer.parseInt(evalStr));
            return res;
        }
        char[] chs = evalStr.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (!Character.isDigit(chs[i])) {
                List<Integer> resLeft = evaluateExpression(evalStr.substring(0, i));
                List<Integer> resRight = evaluateExpression(evalStr.substring(i + 1));
                for (Integer j : resLeft) {
                    for (Integer k : resRight) {
                        if (chs[i] == '+') {
                            res.add(j + k);
                        } else if (chs[i] == '-') {
                            res.add(j - k);
                        } else if (chs[i] == '*') {
                            res.add(j * k);
                        }
                    }
                }
            }
        }
        return res;
    }
}
```

#### [Java Source Code](../../../src/main/java/com/algorithm/subsets/EvaluateExpression.java)
- [Reference](https://www.geeksforgeeks.org/expression-evaluation/)