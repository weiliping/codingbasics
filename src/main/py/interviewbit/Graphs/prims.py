#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'prims' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY edges
#  3. INTEGER start
#


def prims(n, edges, start):
    # Write your code here
    MAX_V = 10**6

    graph, lowestCosts, visited = [], [], []
    for _ in range(n + 1):
        graph.append([])
        lowestCosts.append(MAX_V)
        visited.append(False)
    for e in edges:
        graph[e[0]].append([e[1], e[2]])
        graph[e[1]].append([e[0], e[2]])

    def findLowestNode(lowestCosts, visited, n):
        minV, i = MAX_V, -1
        for j in range(n):
            if visited[j]:
                continue
            if lowestCosts[j] < minV:
                minV = lowestCosts[j]
                i = j
        return [i, minV]
    lowestCosts[start] = 0

    j = 1
    res = 0
    while j < n:
        print(start)
        visited[start] = True
        cur = graph[start]
        for k, v in cur:
            if visited[k]:
                continue
            if lowestCosts[k] > v:
                lowestCosts[k] = v
        start, sub_v = findLowestNode(lowestCosts, visited, n + 1)
        res += sub_v
        j += 1
    return res


n = 5
edges = [[1, 2, 3], [1, 3, 4], [4, 2, 6], [5, 2, 2], [2, 3, 5], [3, 5, 7]]
start = 1

print(prims(n, edges, start))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     m = int(first_multiple_input[1])

#     edges = []

#     for _ in range(m):
#         edges.append(list(map(int, input().rstrip().split())))

#     start = int(input().strip())

#     result = prims(n, edges, start)

#     fptr.write(str(result) + '\n')

#     fptr.close()
