package com.algorithm.contest.weeklycontest269;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindAllPeople {
    public static void main(String[] args) {
        FindAllPeople f = new FindAllPeople();
        int n1 = 6, mettings1[][] = new int[][] {{1,2,5},{2,3,8},{1,5,10}}, fP1 = 1;
        System.out.println(Arrays.toString(f.findAllPeopleII(n1, mettings1, fP1).toArray()));
        System.out.println(Arrays.toString(f.findAllPeopleI(n1, mettings1, fP1).toArray()));
        int n2 = 4, mettings2[][] = new int[][] {{3,1,3},{1,2,2},{0,3,3}}, fP2 = 3;
        System.out.println(Arrays.toString(f.findAllPeopleII(n2, mettings2, fP2).toArray()));
        System.out.println(Arrays.toString(f.findAllPeopleI(n2, mettings2, fP2).toArray()));
        int n3 = 5, mettings3[][] = new int[][] {{3,4,2},{1,2,1},{2,3,1}}, fP3 = 1;
        System.out.println(Arrays.toString(f.findAllPeopleII(n3, mettings3, fP3).toArray()));
        System.out.println(Arrays.toString(f.findAllPeopleI(n3, mettings3, fP3).toArray()));
        int n4 = 6, mettings4[][] = new int[][] {{0,2,1},{1,3,1},{4,5,1}}, fP4 = 1;
        System.out.println(Arrays.toString(f.findAllPeopleII(n4, mettings4, fP4).toArray()));
        System.out.println(Arrays.toString(f.findAllPeopleI(n4, mettings4, fP4).toArray()));
        int n5 = 135, fP5 = 125;
        int mettings5[][] = new int[][]{{26,7,481},{28,120,80},{87,71,36},{11,86,164},{87,32,4},{8,104,240},{110,6,27},{120,126,209},{5,67,220},{61,47,175},{60,52,86},{88,53,453},{40,124,206},{122,22,62},{4,26,433},{46,56,214},{15,6,264},{128,31,313},{24,20,393},{7,20,282},{65,84,216},{55,132,241},{50,32,338},{61,69,459},{130,2,53},{43,106,322},{61,51,99},{43,61,64},{34,37,474},{94,116,338},{19,133,277},{82,40,148},{124,129,496},{73,82,417},{7,6,416},{61,15,98},{92,45,293},{78,109,130},{120,9,181},{84,23,390},{102,78,263},{104,130,262},{46,124,25},{125,101,112},{131,44,427},{78,71,96},{81,16,73},{58,49,18},{72,113,437},{28,119,3},{9,19,249},{113,121,58},{18,93,219},{112,117,412},{69,110,111},{100,44,377},{8,121,359},{86,98,57},{78,75,49},{104,58,276},{2,43,178},{73,64,352},{104,37,298},{14,88,184},{76,56,393},{0,90,144},{17,8,219},{31,127,455},{61,101,84},{100,87,398},{3,118,342},{98,50,272},{126,123,113},{28,52,122},{44,69,32},{127,96,473},{113,116,72},{104,46,436},{1,69,343},{51,18,338},{15,23,250},{21,118,258},{98,6,287},{111,34,468},{66,5,163},{86,16,158},{113,4,31},{8,58,421},{58,96,351},{131,101,66},{38,41,19},{78,0,282},{90,128,494},{73,6,246},{117,22,186},{84,88,145},{96,109,119},{20,112,324},{74,2,6},{46,60,365},{50,17,117},{88,34,310},{4,53,89},{102,81,454},{75,10,172},{71,39,481},{4,1,472},{108,73,487},{34,23,84},{101,82,215},{17,76,83},{38,66,230},{89,72,142},{130,75,145},{44,76,320},{83,128,131},{108,121,245},{9,33,234},{42,9,394},{125,110,453},{89,27,127},{79,17,40},{119,25,434},{12,118,296},{79,124,430},{61,70,353},{0,125,447},{7,27,330},{27,132,406},{43,3,214},{49,11,246},{19,31,158},{41,4,438},{9,115,28},{118,128,314},{109,64,280},{99,105,486},{10,29,8},{30,51,179},{53,29,27},{105,12,143},{113,43,326},{123,90,126},{117,14,9},{65,10,20},{24,77,494},{80,24,308},{16,106,347},{100,41,384},{104,7,293},{34,15,464},{98,18,331},{128,80,432},{55,93,164},{50,30,397},{68,65,396},{122,44,383},{125,122,192},{117,110,261},{32,8,229},{24,132,183},{2,30,159},{70,76,151},{79,111,242},{108,33,260},{91,25,427},{36,2,360},{96,111,270},{85,104,456},{84,24,408},{11,16,471},{109,7,58},{90,35,232},{80,58,298},{74,67,41},{11,96,425},{108,79,272},{8,118,305},{82,53,470},{89,85,450},{94,60,230},{13,39,321},{23,48,195},{92,49,452},{60,86,92},{95,120,31},{28,45,429},{90,71,153},{51,19,132},{88,60,258},{121,83,377},{134,95,130},{84,129,341},{51,105,106},{70,125,138},{75,43,68},{108,7,124},{59,21,480},{30,31,425},{93,134,23},{68,76,109},{82,120,237},{20,120,50},{21,70,316},{105,48,383},{33,23,133},{92,21,147},{16,94,281},{30,74,70},{49,29,282},{61,103,273},{64,116,112},{0,34,393},{100,26,386},{99,12,298},{23,3,113},{69,53,463},{6,81,185},{127,74,128},{66,74,7},{11,61,270},{100,49,458},{69,103,429},{83,61,70},{57,96,469},{83,134,66},{40,120,116},{5,111,310},{11,97,422},{84,12,101},{24,8,391},{33,75,256},{118,98,307},{111,43,384},{18,28,127},{79,119,367},{129,113,331},{126,58,293},{18,23,445},{41,132,352},{120,74,82},{29,81,53},{123,29,462},{25,120,10},{4,33,359},{98,48,91},{104,3,187},{128,40,376},{89,37,314},{124,122,44},{29,77,88},{96,117,349},{97,17,483},{82,117,243},{98,69,311},{14,7,500},{72,36,148},{90,53,491},{125,71,432},{24,119,15},{130,118,161},{54,73,389},{88,32,276},{35,41,183},{94,56,336},{8,34,407},{10,50,421},{127,18,231},{126,115,109},{96,70,231},{36,32,272},{63,23,252},{52,57,409},{91,10,336},{122,38,398},{42,86,481},{32,91,8},{56,81,258},{49,6,439},{116,40,72},{119,62,17},{40,124,289},{134,69,355},{32,59,121},{65,129,258},{106,61,146},{94,41,113},{82,34,209},{119,44,462},{88,62,16},{30,134,365},{30,56,42},{104,134,397},{129,25,226},{104,14,55},{123,92,194},{85,21,386},{57,13,141},{76,13,118},{48,88,436},{121,0,155},{39,74,38},{35,104,188},{80,100,475},{128,34,219},{126,114,444},{13,25,465},{68,95,293},{132,56,204},{102,126,427},{105,70,34},{116,41,258},{97,128,458},{77,98,496},{27,123,425},{54,32,496},{77,63,17},{124,66,253},{132,55,283},{63,87,295},{82,33,267},{123,49,78},{86,31,468},{3,21,459},{51,21,342},{123,71,257},{12,90,431},{41,29,145},{110,124,355},{0,19,174},{79,133,414},{58,22,183},{72,79,429},{72,128,69},{85,70,429},{22,77,489},{2,108,50},{101,12,128},{68,53,41},{85,98,374},{54,44,211},{3,56,390},{86,87,317},{114,82,282},{95,88,439},{1,35,187},{17,57,220},{118,6,443},{11,81,4},{117,50,253},{60,29,118},{8,5,364},{51,7,194},{121,45,235},{38,13,170},{21,41,218},{64,24,294},{50,80,73},{114,67,332},{12,39,32},{68,36,390},{89,127,110},{113,126,239},{16,117,425},{43,42,454},{17,104,192},{7,133,28},{84,56,335},{63,44,449},{108,73,96},{53,27,171},{103,31,256},{87,47,372},{16,30,126},{59,63,49},{108,56,66},{74,10,431},{8,54,302},{74,117,452},{17,74,159},{85,20,475},{102,54,299},{16,42,123},{105,63,453},{9,37,403},{1,52,390},{38,16,418},{41,11,144},{71,98,76},{75,85,57},{98,125,469},{48,45,114},{58,52,7},{125,27,311},{84,107,301},{1,47,475},{125,43,458},{5,89,165},{2,21,200},{129,53,133},{98,17,429},{78,101,428},{80,45,459},{95,37,247},{8,63,226},{115,9,174},{5,72,340},{42,57,236},{42,5,144},{76,80,159},{76,45,484},{79,10,214},{89,123,443},{95,12,345},{131,68,257},{98,20,6},{79,69,123},{127,109,372},{71,94,155},{34,108,364}};
        System.out.println(Arrays.toString(f.findAllPeopleII(n5, mettings5, fP5).toArray()));
        System.out.println(Arrays.toString(f.findAllPeopleI(n5, mettings5, fP5).toArray()));
    }
    public List<Integer> findAllPeopleII(int n, int[][] meetings, int firstPerson) {
        boolean[] secrets = new boolean[n];
        secrets[0] = secrets[firstPerson] = true;

        Arrays.sort(meetings, (a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        int len = meetings.length;
        int i = 0;

        while (i < len) {
            int j = i;
            while (j + 1 < len && meetings[j + 1][2] == meetings[j][2]) {
                j++;
            }
            List<Integer>[] graph = new ArrayList[n];
            Set<Integer> list = new HashSet<>();
            for (int k = i; k <= j; k++) {
                int[] meet = meetings[k];
                if (graph[meet[0]] == null) {
                    graph[meet[0]] = new ArrayList<>();
                }
                if (graph[meet[1]] == null) {
                    graph[meet[1]] = new ArrayList<>();
                }
                graph[meet[0]].add(meet[1]);
                graph[meet[1]].add(meet[0]);
                list.add(meet[0]);
                list.add(meet[1]);
            }
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for (int m : list) {
                if (secrets[m]) {
                    queue.offer(m);
                }
            }
            while (!queue.isEmpty()) {
                int parent = queue.poll();
                if (graph[parent] != null) {
                    for (int c : graph[parent]) {
                        if (!secrets[c]) {
                            secrets[c] = true;
                            queue.offer(c);
                        }
                    }
                }
            }
            i = j + 1;
        }
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < n; j++) {
            if (secrets[j]) {
                res.add(j);
            }
        }
        return res;
    }
    public List<Integer> findAllPeopleI(int n, int[][] meetings, int firstPerson) {
        int[] parents = new int[n];
        Arrays.setAll(parents, a -> a);
        parents[firstPerson] = 0;
        Arrays.sort(meetings, (a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        int len = meetings.length, i = 0;
        while (i < len) {
            int j = i;
            while (j + 1 < len && meetings[j + 1][2] == meetings[j][2]) {
                j++;
            }
            for (int k = i; k <= j; k++) {
                int[] m = meetings[k];
                int x = m[0], y = m[1];
                int p = find(parents, x);
                int q = find(parents, y);
                if (p == 0 || q == 0) {
                    if (q != 0) {
                        parents[q] = p;
                        continue;
                    }
                    parents[p] = q;
                }
            }
            i = j + 1;
        }
        return IntStream.range(0, n)
                .filter(ind -> parents[ind] == 0)
                .mapToObj(ind -> ind)
                .collect(Collectors.toList());
    }

    public static int find(int[] parents, int curr) {
        if (parents[curr] != curr) {
            return find(parents, parents[curr]);
        }
        return curr;
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] m : meetings) {
            graph[m[0]].add(new int[] {m[1], m[2]});
            graph[m[1]].add(new int[] {m[0], m[2]});
        }

        for (int i = 0; i < n; i++) {
            Collections.sort(graph[i], (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        }

        Set<Integer> res = new HashSet<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {0, -1});
        queue.offer(new int[] {firstPerson, -1});
        boolean[] visited = new boolean[n];
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            res.add(cur[0]);
            if (visited[cur[0]]) {
                continue;
            }
            visited[cur[0]] = true;
            if (graph[cur[0]].isEmpty()) {
                continue;
            }
            List<int[]> childs = graph[cur[0]];
            int len = childs.size();
            int indx = binarySearch(graph[cur[0]], len, cur[1]);
            if (indx == -1) {
                continue;
            }
            for (int i = indx; i < len; i++) {
                int[] child = childs.get(i);
//                if (!res.contains(child[0])) {
                    queue.offer(child);
//                }
            }
        }
        return new ArrayList<>(res);
    }

    static int binarySearch(List<int[]> num, int n, int v) {
        int i = 0, j = n - 1;
        while (i <= j) {
            int mid = i + ((j - i) >> 1);
            if (num.get(mid)[1] < v) {
                i = mid + 1;
            } else {
                if (mid == 0 || num.get(mid - 1)[1] < v) {
                    return mid;
                }
                j = mid - 1;
            }
        }
        return -1;
    }
}
