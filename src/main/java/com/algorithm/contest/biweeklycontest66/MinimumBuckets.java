package com.algorithm.contest.biweeklycontest66;

public class MinimumBuckets {
    public static void main(String[] args) {
        MinimumBuckets m = new MinimumBuckets();
        System.out.println(m.minimumBuckets("H..H"));
        System.out.println(m.minimumBuckets(".H.H."));
        System.out.println(m.minimumBuckets(".HHH."));
        System.out.println(m.minimumBuckets("H"));
        System.out.println(m.minimumBuckets("."));
    }
    public int minimumBuckets(String street) {
        char[] chrs = street.toCharArray();
        int cnt = 0, n = chrs.length;

        if (n == 1) {
            return chrs[0] == 'H' ? -1 : 0;
        }

        if (chrs[0] == 'H') {
            if (chrs[1] == 'H') {
                return -1;
            }
            chrs[1] = 'B';
            cnt++;
        }
        if (chrs[n - 1] == 'H') {
            if (chrs[n - 2] == 'H') {
                return -1;
            }
            if (chrs[n - 2] == '.') {
                chrs[n - 2] = 'B';
                cnt++;
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (chrs[i] == 'H') {
                if (chrs[i - 1] == 'H') {
                    if (chrs[i + 1] == 'H') {
                        return -1;
                    }
                    if (chrs[i + 1] == '.') {
                        chrs[i + 1] = 'B';
                        cnt++;
                    }
                    continue;
                }
                if (chrs[i + 1] == 'H') {
                    if (chrs[i - 1] == '.') {
                        chrs[i - 1] = 'B';
                        cnt++;
                    }
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            if (chrs[i] == 'H') {
                if (chrs[i - 1] == 'B' || chrs[i + 1] == 'B') {
                    continue;
                }
                if (chrs[i - 1] == '.' && chrs[i + 1] == '.') {
                    chrs[i + 1] = 'B';
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
