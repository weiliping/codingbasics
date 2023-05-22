package com.algorithm.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EvaluateExpression {

    public static void main(String[] args) {
        List<Integer> res = evaluateExpression("2*3-4-5");
        System.out.println(Arrays.toString(res.toArray()));
    }

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
