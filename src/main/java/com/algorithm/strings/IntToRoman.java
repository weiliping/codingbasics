package com.algorithm.strings;

import java.util.ArrayList;
import java.util.List;

public class IntToRoman {

    /**
     * #12
     * https://leetcode-cn.com/problems/integer-to-roman
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new IntToRoman().intToRoman2(3923));
    }

    public String intToRoman2(int num) {

        String[] v1 = new String[] { "", "M", "MM", "MMM" };
        String[] v2 = new String[] { "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" };
        String[] v3 = new String[] { "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" };
        String[] v4 = new String[] { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" };
        if (num < 1 || num > 3999) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(v1[num / 1000]);
        sb.append(v2[(num % 1000) / 100]);
        sb.append(v3[(num % 100) / 10]);
        sb.append(v4[num % 10]);
        return sb.toString();
    }

    public String intToRoman(int num) {
        if (num < 1 || num > 3999) {
            return null;
        }

        List<NumContainer> nums = new ArrayList<>();
        int res = num;
        int val, pos = 0;
        while (res > 0) {
            val = res % 10;
            res = res / 10;
            nums.add(new NumContainer(pos, val));
            pos++;
        }
        StringBuilder result = new StringBuilder();

        for (int i = nums.size() - 1; i >= 0; i--) {
            NumContainer n = nums.get(i);
            if (n.val == 0) {
                continue;
            }
            result.append(getRomanNum(nums.get(i).pos, nums.get(i).val));
        }
        return result.toString();
    }

    class NumContainer {
        int pos;
        int val;

        public NumContainer(int pos, int val) {
            this.pos = pos;
            this.val = val;
        }
    }

    static String getRomanNum(int pos, int val) {
        if (val > 0 && val < 4) {
            return getRomanLessFour(pos, val);
        } else if (val == 4 || val == 5 || val == 9) {
            return getRomanNumByPos(pos, val);
        } else {
            return getRomanLessNine(pos, val);
        }
    }

    static String getRomanLessFour(int pos, int val) {
        StringBuilder sb = new StringBuilder();
        while (val > 0) {
            sb.append(getRomanNumByPos(pos, val));
            val--;
        }
        return sb.toString();
    }

    static String getRomanLessNine(int pos, int val) {
        StringBuilder sb = new StringBuilder();
        val = val - 5;
        sb.append(getRomanNumByPos(pos, 5));
        while (val > 0) {
            sb.append(getRomanNumByPos(pos, val));
            val--;
        }
        return sb.toString();
    }

    static String getRomanNumByPos(int pos, int val) {
        if (pos == 0) {
            if (val < 4) {
                return "I";
            }
            if (val == 4) {
                return "IV";
            }
            if (val == 5) {
                return "V";
            }
            return "IX";
        } else if (pos == 1) {
            if (val < 4) {
                return "X";
            }
            if (val == 4) {
                return "XL";
            }
            if (val == 5) {
                return "L";
            }
            return "XC";
        } else if (pos == 2) {
            if (val < 4) {
                return "C";
            }
            if (val == 4) {
                return "CD";
            }
            if (val == 5) {
                return "D";
            }
            return "CM";
        } else {
            if (val < 4) {
                return "M";
            }
            return "M";
        }
    }
}

