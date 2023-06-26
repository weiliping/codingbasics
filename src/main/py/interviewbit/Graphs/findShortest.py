#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the findShortest function below.

#
# For the weighted graph, <name>:
#
# 1. The number of nodes is <name>_nodes.
# 2. The number of edges is <name>_edges.
# 3. An edge exists between <name>_from[i] to <name>_to[i].
#
#


def findShortest(graph_nodes, graph_from, graph_to, ids, val):
    # solve here
    mp = {}

    for i in range(len(ids)):
        id = ids[i]
        arr = mp.get(id, [])
        arr.append(i + 1)
        mp[id] = arr
    cols = mp.get(ids[val - 1])
    if len(cols) < 2:
        return -1

    graph = [[] for _ in range(graph_nodes + 1)]
    n = len(graph_from)
    for i in range(n):
        graph[graph_from[i]].append(graph_to[i])
        graph[graph_to[i]].append(graph_from[i])

    def findPaths(graph, graph_nodes, ids, id, val):
        q = []
        visited = [False for _ in range(graph_nodes + 1)]
        q.append([id, 0])
        while len(q) > 0:
            cur = q.pop(0)
            visited[cur[0]] = True
            chs = graph[cur[0]]
            for chInd in chs:
                if visited[chInd]:
                    continue
                if ids[chInd - 1] == val:
                    return cur[1] + 1
                q.append([chInd, cur[1] + 1])
        return graph_nodes + 1
    res = graph_nodes + 1
    for id in cols:
        r = findPaths(graph, graph_nodes, ids, id, val)
        res = min(r, res)
    if res == graph_nodes + 1:
        return -1
    return res


graph_nodes = 5
graph_from = [1, 1, 2, 3]
graph_to = [2, 3, 4, 5]
ids = [1, 2, 3, 3, 2]
val = 2
print(findShortest(graph_nodes, graph_from, graph_to, ids, val))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     graph_nodes, graph_edges = map(int, input().split())

#     graph_from = [0] * graph_edges
#     graph_to = [0] * graph_edges

#     for i in range(graph_edges):
#         graph_from[i], graph_to[i] = map(int, input().split())

#     ids = list(map(int, input().rstrip().split()))

#     val = int(input())

#     ans = findShortest(graph_nodes, graph_from, graph_to, ids, val)

#     fptr.write(str(ans) + '\n')

#     fptr.close()
