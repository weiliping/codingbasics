package com.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EarliestAndLatest {
    public static void main(String[] args) {
        // int n = 11;
        // int s = 1;
        // while (n > 1) {
        //     System.out.println("n: " + n + ", s: " + s);
        //     n = ((n >> 1) + (n % 2));
        //     s++;
        // }
        // int[] players = new int[n];
        // Arrays.setAll(players, i -> i + 1);
        // System.out.println(Arrays.toString(players));

        
        
        // int h = n >> 1;
        // int[] select = new int[h + (n & 1)];
        // int l = 0, r = 0;
        // int[] res = new int[]{n, 0};
        EarliestAndLatest earliestAndLatest = new EarliestAndLatest();
        // List<int[]> allPlayers = new ArrayList<>();
        int[] res = earliestAndLatest.earliestAndLatest(11, 2, 4);
        // int[] players1 = new int[]{2, 4, 6};
        // int[] select = new int[2];
        // List<int[]> res2 = new ArrayList<>();
        // earliestAndLatest.helper(players1, 1, 0, 0, select, 2, 4, res2);


        // System.out.println(Arrays.toString(res2.get(0)));
        // System.out.println(h);
        System.out.println(Arrays.toString(res) + " final result");
    }
    public int[] earliestAndLatest(int n, int firstPlayer, int secondPlayer) {
        int[] players = new int[n];
        Arrays.setAll(players, i -> i + 1);
        
        int[] res = new int[]{n, 0};
        List<int[]> allPlayers = new ArrayList<>();
        allPlayers.add(players);
        int s = 1;
        while (n > 1) {
            List<int[]> subPlayers = new ArrayList<>();
            for (int i = 0; i < allPlayers.size(); i++) {
                int[] select = allPlayers.get(i);
                int h = select.length >> 1;
                boolean isValid = false;
                for (int j = 0; j < h; j++) {
                    if (select[j] == firstPlayer && select[select.length - j - 1] == secondPlayer) {
                        res[0] = Math.min(res[0], s);
                        res[1] = Math.max(res[1], s);
                        isValid = true;
                        break;
                    }
                }
                if (isValid) {
                    continue;
                }
                
                int[] subSelect = new int[h + (select.length & 1)];
                List<int[]> subPlayerList = new ArrayList<>();
                helper(select, h, 0, 0, subSelect, firstPlayer, secondPlayer, subPlayerList);
                subPlayers.addAll(subPlayerList);
            }
            allPlayers = new ArrayList<>(subPlayers);
            n = ((n >> 1) + (n % 2));
            s++;
        }
        return res;
    }

    public void helper(int[] players, int h, int l, int r, int[] select, int firstPlayer, int secondPlayer, List<int[]> res) {
        int i = l + r;
        if (i == h) {  
            if ((players.length & 1) == 1) {
                select[l] = players[h];
            }
            System.out.println(Arrays.toString(select));
            res.add(select.clone());
            return;
        }
        if (players[i] == firstPlayer && players[players.length - i - 1] == secondPlayer) {
            return;
        }
        if (players[i] == firstPlayer || players[i] == secondPlayer) {
            select[l] = players[i];
            helper(players, h, l + 1, r, select, firstPlayer, secondPlayer, res);
        } else if (players[players.length - i - 1] == firstPlayer || players[players.length - i - 1] == secondPlayer) {
            select[select.length - r - 1] = players[players.length - i - 1];
            helper(players, h, l, r + 1, select, firstPlayer, secondPlayer, res); 
        } else {
            select[l] = players[i];
            helper(players, h, l + 1, r, select, firstPlayer, secondPlayer, res);
            select[select.length - r - 1] = players[players.length - i - 1];
            helper(players, h, l, r + 1, select, firstPlayer, secondPlayer, res); 
        }
    }
}
