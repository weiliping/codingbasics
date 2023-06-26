#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minTime' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. 2D_INTEGER_ARRAY roads
#  2. INTEGER_ARRAY machines
#


def minTime(roads, machines):
    # Write your code here
    cost = [0]
    n = len(roads)
    MAX_V = 10**6 + 1
    cap = [False for _ in range(n)]
    s = set(machines)
    g = [[] for _ in range(n + 1)]
    cData = [None for _ in range(n + 1)]
    visited = [False for _ in range(n + 1)]
    for k in range(n):
        (i, j, c) = roads[k]
        if i in s and j in s:
            cost[0] += c
            cap[k] = True
            continue
        g[i].append([j, k])
        g[j].append([i, k])

    def dfsHelper(i, visited, cap, g, cData, s, roads, cost):
        visited[i] = True
        if cData[i]:
            return cData[i]
        ms = {}
        if i in s:
            ms[i] = MAX_V
        #  To check current index is leaf
        if len(g[i]) == 1 and visited[g[i][0][0]]:
            cData[i] = ms
            return cData[i]
        # Here has child
        for c in g[i]:
            if visited[c[0]]:
                continue
            ch = dfsHelper(c[0], visited, cap, g, cData, s, roads, cost)
            if len(ch) == 0:
                continue
            k = c[1]
            v = roads[k][2]
            nDict = {}
            for key in ch:
                k1 = ch[key]
                if k1 == MAX_V:
                    nDict[key] = k
                else:
                    v1 = roads[k1][2]
                    nDict[key] = k if v < v1 else k1
            if len(ms) != 0:
                for mInd in ms:
                    lK = ms[mInd]
                    for nInd in nDict:
                        rK = nDict[nInd]
                        capK = -1
                        if lK == MAX_V:
                            capK = rK
                        elif rK == MAX_V:
                            capK = lK
                        else:
                            capK = lK if roads[lK][2] < roads[rK][2] else rK
                        if not cap[capK]:
                            cost[0] += roads[capK][2]
                            cap[capK] = True
            ms = ms | nDict
        cData[i] = ms
        return cData[i]
    for a in s:
        dfsHelper(a, visited, cap, g, cData, s, roads, cost)
    return cost[0]


def minTime2(roads, machines):
    # Write your code here
    MAX_V = 10**6 + 1
    cost = 0
    n = len(roads)
    broken_edges = [False for _ in range(n)]
    s = set(machines)
    g = [[] for _ in range(n + 1)]
    for k in range(n):
        (i, j, c) = roads[k]
        if i in s and j in s:
            cost += c
            broken_edges[k] = True
            continue
        g[i].append([j, k])
        g[j].append([i, k])

    mapVals = [{} for _ in range(n + 1)]
    for m in s:
        q = []
        q.append(m)
        visited = [False for _ in range(n + 1)]
        visited[m] = True
        mapVals[m][m] = MAX_V
        while len(q) > 0:
            cur = q.pop()
            points = mapVals[cur]
            for c in g[cur]:
                if visited[c[0]]:
                    continue
                k = c[1]
                if broken_edges[k]:
                    break
                prePoints = mapVals[c[0]]
                ps = {}
                for u in points:
                    k1 = points[u]
                    if k1 == MAX_V or roads[k1][2] > roads[k][2]:
                        ps[u] = k
                    else:
                        ps[u] = k1
                    if len(prePoints) != 0:
                        for v in prePoints:
                            k2 = prePoints[v]
                            if k2 == MAX_V or roads[ps[u]][2] < roads[k2][2]:
                                if not broken_edges[ps[u]]:
                                    broken_edges[ps[u]] = True
                                    cost += roads[ps[u]][2]
                            else:
                                if not broken_edges[k2]:
                                    broken_edges[k2] = True
                                    cost += roads[k2][2]
                mapVals[c[0]] = ps | prePoints
                q.append(c[0])
                visited[c[0]] = True
    return cost


# 610
machines = [1, 95, 90, 11, 48, 49, 23, 6, 0, 76, 3,
            83, 85, 31, 44, 54, 87, 38, 16, 61, 22, 21, 29]

f = open(os.path.dirname(os.path.abspath(__file__)) +
         '/min_time_params.txt', 'r')
roads = []
for a in f:
    u, v, k = a.strip().split(" ")
    roads.append([int(u), int(v), int(k)])

print(minTime(roads, machines))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     k = int(first_multiple_input[1])

#     roads = []

#     for _ in range(n - 1):
#         roads.append(list(map(int, input().rstrip().split())))

#     machines = []

#     for _ in range(k):
#         machines_item = int(input().strip())
#         machines.append(machines_item)

#     result = minTime(roads, machines)

#     fptr.write(str(result) + '\n')

#     fptr.close()
