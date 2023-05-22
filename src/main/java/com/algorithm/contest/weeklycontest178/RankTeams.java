package com.algorithm.contest.weeklycontest178;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RankTeams {

    public static void main(String[] args) {
        RankTeams r = new RankTeams();
        String[] votes = new String[] {"ABC","ACB","ABC","ACB","ACB"};
        String[] votes1 = new String[] {"WXYZ","XYZW"};
        String[] votes2 = new String[] {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        String[] votes3 = new String[] {"BCA","CAB","CBA","ABC","ACB","BAC"};
        String[] votes4 = new String[] {"M","M","M","M"};
        System.out.println(r.rankTeams(votes));
        System.out.println(r.rankTeams(votes1));
        System.out.println(r.rankTeams(votes2));
        System.out.println(r.rankTeams(votes3));
        System.out.println(r.rankTeams(votes4));
    }

    public String rankTeams(String[] votes) {
        int n = votes.length;
        if (n == 1) {
            return votes[0];
        }

        int m = votes[0].length();

        Map<Character, Integer> inds = new HashMap<>();
        Vote[] vArr = new Vote[m];
        int curInd = 0;
        for (String vote : votes) {
            char[] chrs = vote.toCharArray();
            for (int i = 0; i < m; i++) {
                Integer ind = inds.get(chrs[i]);
                if (ind == null) {
                    ind = curInd++;
                    inds.put(chrs[i], ind);
                    Integer[] cnts = new Integer[m];
                    Arrays.fill(cnts, 0);
                    Vote v = new Vote(chrs[i], cnts);
                    vArr[ind] = v;
                }
                 vArr[ind].votes[i]++;
            }
        }
        Arrays.sort(vArr);
        StringBuilder sb = new StringBuilder();
        for (int j = m - 1; j >= 0; j--) {
            sb.append(vArr[j].chr);
        }
        return sb.toString();
    }

    class Vote implements Comparable {
        public char chr;
        public Integer[] votes;

        public Vote(char chr, Integer[] votes) {
            this.chr = chr;
            this.votes = votes;
        }

        @Override
        public int compareTo(Object o) {
            Vote v2 = (Vote)o;

            Integer[] arr1 = this.votes, arr2 = v2.votes;

            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == arr2[i]) {
                    continue;
                }
                if (arr1[i] > arr2[i]) {
                    return 1;
                } else {
                    return -1;
                }
            }
            return this.chr > v2.chr ? -1 : 1;
        }
    }
}

