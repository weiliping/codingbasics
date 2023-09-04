#!/bin/python3

import math
import os
import random
import re
import sys

dp = dict()

MAX_V = 99999


def shortestPath(graph, n, queries):
    d = [[MAX_V for _ in range(n)] for _ in range(n)]
    s = set()
    for u, v, w in graph:
        d[u][v] = w
        s.add(u)
        s.add(v)
    for u in s:
        d[u][u] = 0
    for k in range(1, n):
        for i in range(1, n):
            for j in range(1, n):
                d[i][j] = min(d[i][j], d[i][k] + d[k][j])
    for x, y in queries:
        print(d[x][y] if d[x][y] != MAX_V else -1)


def findMinDist(graph, x, y):
    if len(graph) == 0:
        return -1
    if x == y:
        return 0

    def toKey(x, y):
        return str(x) + ':' + str(y)

    def toRes(v):
        return v if v != MAX_V else -1

    k = toKey(x, y)
    if k in dp.keys():
        return toRes(dp.get(k))
    visited = [False for _ in range(401)]
    visited[x] = True
    min_v = MAX_V
    child = graph[x]
    if child:
        if y in child.keys():
            min_v = child[y]
            visited[y] = True
        q = []
        for k in child.keys():
            if k == y:
                continue
            q.append([k, child[k]])
        while q:
            u, w = q.pop(0)
            k1 = toKey(u, y)
            if k1 in dp.keys():
                v1 = dp[k1]
                if min_v > v1 + w:
                    min_v = v1 + w
            elif u == y and min_v > w:
                min_v = w
            if not visited[u]:
                if u in graph.keys():
                    next1 = graph[u]
                    for k1 in next1.keys():
                        q.append([k1, next1[k1] + w])
                visited[u] = True

        dp[toKey(x, y)] = min_v
        return toRes(min_v)


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


# f = open(os.path.dirname(os.path.abspath(__file__)) +
#          '/min_dist_params.txt', 'r')
# roads = []
# for a in f:
#     u, v, k = a.strip().split(" ")
#     roads.append([int(u), int(v), int(k)])

# dp = [[] for _ in range(401)]

# for u, v, w in roads:
#     dp[u].append([v, w])
# print(dp)

if __name__ == '__main__':
    road_nodes, road_edges = map(int, input().rstrip().split())
    graph = []
    n = -1
    s = set()
    for i in range(road_edges):
        road_from, road_to, road_weight = map(int, input().rstrip().split())
        n = max(n, road_from, road_to)
        s.add(road_from)
        graph.append([road_from, road_to, road_weight])
        # f = open(os.path.dirname(os.path.abspath(__file__)) +
        #          '/min_dist_params.txt', 'r')

        # for a in f:
        #     u, v, k = a.strip().split(" ")
        #     a = [int(u), int(v), int(k)]
        #     graph.append(a)
        #     n = max(n, a[0], a[1])
        #     s.add(a[0])
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
    # f = open(os.path.dirname(os.path.abspath(__file__)) +
    #  '/min_dist_params4.txt', 'r')
    for q_itr in range(q):
        # for a in f:
        first_multiple_input = input().rstrip().split()

        x = int(first_multiple_input[0])

        y = int(first_multiple_input[1])
        # x, y = a.strip().split(" ")
        # x, y = int(x), int(y)
        print(dp[x][y] if dp[x][y] < MAX_V else - 1)
