#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'getCost' function below.
#
# The function accepts WEIGHTED_INTEGER_GRAPH g as parameter.
#

#
# For the weighted graph, <name>:
#
# 1. The number of nodes is <name>_nodes.
# 2. The number of edges is <name>_edges.
# 3. An edge exists between <name>_from[i] and <name>_to[i]. The weight of the edge is <name>_weight[i].
#
#


def getCost(g_nodes, g_from, g_to, g_weight):
    # Print your answer within the function and return nothing
    import heapq
    MAX_V = 10**10
    g = [[] for _ in range(g_nodes + 1)]
    n = len(g_from)
    for i in range(n):
        v = g[g_from[i]]
        v.append([g_to[i], g_weight[i]])
        g[g_from[i]] = v
        u = g[g_to[i]]
        u.append([g_from[i], g_weight[i]])
        g[g_to[i]] = u

    distances = [MAX_V for _ in range(g_nodes + 1)]
    distances[1] = 0
    q = []
    heapq.heappush(q, [1, 0])
    while len(q) > 0:
        (node, val) = heapq.heappop(q)
        for (child, chV) in g[node]:
            mV = max(val, chV)
            if mV < distances[child]:
                distances[child] = mV
                q.append([child, mV])
    if distances[g_nodes] < MAX_V:
        print(distances[g_nodes])
    else:
        print("NO PATH EXISTS")


if __name__ == '__main__':
    g_nodes, g_edges = map(int, input().rstrip().split())

    g_from = [0] * g_edges
    g_to = [0] * g_edges
    g_weight = [0] * g_edges

    for i in range(g_edges):
        g_from[i], g_to[i], g_weight[i] = map(int, input().rstrip().split())

    getCost(g_nodes, g_from, g_to, g_weight)
