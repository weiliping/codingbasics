#!/bin/python3

import math
import os
import random
import re
import sys
MAX_V = 99999


def minDist(dp, g, s):
    for k in s:
        q = []
        q.append(k)
        while q:
            u = q.pop(0)
            if u in g.keys():
                for c_u in g[u].keys():
                    c_w = g[u][c_u]
                    n_w = dp[k][u] + c_w
                    if dp[k][c_u] > n_w:
                        dp[k][c_u] = n_w
                        q.append(c_u)


if __name__ == '__main__':
    road_nodes, road_edges = map(int, input().rstrip().split())
    graph, n, s = [], -1, set()
    for i in range(road_edges):
        road_from, road_to, road_weight = map(int, input().rstrip().split())
        n = max(n, road_from, road_to)
        s.add(road_from)
        graph.append([road_from, road_to, road_weight])
    dp = [[MAX_V for _ in range(n + 1)] for _ in range(n + 1)]
    g = dict()
    for u, v, w in graph:
        dp[u][u] = 0
        dp[v][v] = 0
        if u in g.keys():
            s_arr = g[u]
        else:
            s_arr = {}
        s_arr[v] = w
        g[u] = s_arr
    minDist(dp, g, s)
    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        x = int(first_multiple_input[0])

        y = int(first_multiple_input[1])
        print(dp[x][y] if dp[x][y] < MAX_V else - 1)
