package com.algorithm.selfpractice.round2;

import java.util.ArrayList;

public class IsPathCrossing {

    public static void main(String[] args) {
        System.out.println(new IsPathCrossing().isPathCrossing("NES"));
    }

    public boolean isPathCrossing(String path) {
        if (path == null || path.isEmpty()) {
            return false;
        }
        ArrayList<String> points = new ArrayList<>();
        points.add(String.valueOf(0 + "," + 0));
        for (int i = 0; i < path.length(); i++) {
            String[] curr = points.get(points.size() - 1).split(",");
            int x = Integer.valueOf(curr[0]);
            int y = Integer.valueOf(curr[1]);
            char c = path.charAt(i);
            if (c == 'N') {
                y++;
            }
            if (c == 'S') {
                y--;
            }
            if (c == 'E') {
                x++;
            }
            if (c == 'W') {
                x--;
            }
            String newPoint = String.valueOf(x + "," + y);
            if (points.contains(newPoint)) {
                return true;
            }
            points.add(newPoint);
        }
        return false;
    }
}
