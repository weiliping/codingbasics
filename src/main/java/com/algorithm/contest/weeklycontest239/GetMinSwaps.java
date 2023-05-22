package com.algorithm.contest.weeklycontest239;

/**
 * https://leetcode-cn.com/contest/weekly-contest-239
 * https://leetcode-cn.com/problems/minimum-adjacent-swaps-to-reach-the-kth-smallest-number/
 * #1850. 邻位交换的最小次数
 *
 * 给你一个表示大整数的字符串 num ，和一个整数 k 。
 *
 * 如果某个整数是 num 中各位数字的一个 排列 且它的 值大于 num ，则称这个整数为 妙数 。可能存在很多妙数，但是只需要关注 值最小 的那些。
 *
 * 例如，num = "5489355142" ：
 * 第 1 个最小妙数是 "5489355214"
 * 第 2 个最小妙数是 "5489355241"
 * 第 3 个最小妙数是 "5489355412"
 * 第 4 个最小妙数是 "5489355421"
 * 返回要得到第 k 个 最小妙数 需要对 num 执行的 相邻位数字交换的最小次数 。
 *
 * 测试用例是按存在第 k 个最小妙数而生成的。
 *
 * 示例 1：
 *
 * 输入：num = "5489355142", k = 4
 * 输出：2
 * 解释：第 4 个最小妙数是 "5489355421" ，要想得到这个数字：
 * - 交换下标 7 和下标 8 对应的位："5489355142" -> "5489355412"
 * - 交换下标 8 和下标 9 对应的位："5489355412" -> "5489355421"
 * 示例 2：
 *
 * 输入：num = "11112", k = 4
 * 输出：4
 * 解释：第 4 个最小妙数是 "21111" ，要想得到这个数字：
 * - 交换下标 3 和下标 4 对应的位："11112" -> "11121"
 * - 交换下标 2 和下标 3 对应的位："11121" -> "11211"
 * - 交换下标 1 和下标 2 对应的位："11211" -> "12111"
 * - 交换下标 0 和下标 1 对应的位："12111" -> "21111"
 *
 */
public class GetMinSwaps {
    public static void main(String[] args) {
        System.out.println(getMinSwaps("5489355142", 4));
        System.out.println(getMinSwaps("11112", 4));
        System.out.println(getMinSwaps("99499", 1));
    }

    public static int getMinSwaps(String num, int k) {
        String numK = nextKPermutation(num, k);
        char[] nums = num.toCharArray(), numsK = numK.toCharArray();
        int n = nums.length, cnt = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] != numsK[i]) {
                for (int j = i + 1; j < n; j++) {
                    if (nums[j] == numsK[i]) {
                        for (int l = j - 1; l >= i; l--) {
                            cnt++;
                            char t = nums[l];
                            nums[l] = nums[l + 1];
                            nums[l + 1] = t;
                        }
                        break;
                    }
                }
            }
        }
        return cnt;
    }

    public static String nextKPermutation(String numK, int k) {
        char[] chs = numK.toCharArray();
        for (int i = 0; i < k; i++) {
            chs = nextPer(chs);
        }
        return String.valueOf(chs);
    }

    public static char[] nextPer(char[] chs) {
        if (chs == null || chs.length < 2) {
            return chs;
        }

        int nextStart = -1, n = chs.length;

        for (int i = n - 1; i > 0; i--) {
            if (chs[i] > chs[i - 1]) {
                nextStart = i - 1;
                break;
            }
        }

        if (nextStart > -1) {
            for (int j = n - 1; j > 0; j--) {
                if (chs[nextStart] < chs[j]) {
                    char t = chs[j];
                    chs[j] = chs[nextStart];
                    chs[nextStart] = t;
                    break;
                }
            }
        }
        int j = n - 1;
        for (int i = nextStart + 1; i < n && i < j; i++) {
            char t = chs[i];
            chs[i] = chs[j];
            chs[j] = t;
            j--;
        }
        return chs;
    }
}
