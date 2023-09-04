#!/bin/python3

import heapq
import math
import os
import random
import re
import sys
import heapq
#
# Complete the 'shortestReach' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY edges
#  3. INTEGER s
#
MAX_V = 10**5 + 1


def shortestReach(n, edges, s):
    # Write your code here
    m = n + 1
    g = [[] for _ in range(m)]
    for u, v, d in edges:
        g[u].append([v, d])
        g[v].append([u, d])

    def findNote(arr, visited, m):
        k, v = -1, MAX_V
        for i in range(m):
            if not visited[i] and v > arr[i]:
                k, v = i, arr[i]
        return k
    parVals = [MAX_V for _ in range(m)]
    parVals[s] = 0
    visited = [False for _ in range(m)]
    i = 0
    while i < n:
        k = findNote(parVals, visited, m)
        if k == -1:
            break
        visited[k] = True
        for c, v in g[k]:
            if visited[c]:
                continue
            if parVals[c] > parVals[k] + v:
                parVals[c] = parVals[k] + v
        i += 1
    res = []
    for j in range(1, m):
        if j == s:
            continue
        if parVals[j] == MAX_V:
            res.append(-1)
            continue
        res.append(parVals[j])
    return res


def shortestReachI(n, edges, s):
    m = n + 1
    g = [[] for _ in range(m)]
    for u, v, d in edges:
        g[u].append([d, v])
        g[v].append([d, u])
    q = [(0, s)]
    visited = [False for _ in range(m)]
    visited[s] = True
    shortest = [-1 for _ in range(m)]
    while q:
        v, i = heapq.heappop(q)
        for subV, c in g[i]:
            val = v + subV
            if not visited[c]:
                visited[c] = True
                heapq.heappush(q, [val, c])
                shortest[c] = val
            else:
                if shortest[c] > val:
                    ind = q.index([shortest[c], c])
                    q[ind] = [val, c]
                    heapq.heapify(q)
                    shortest[c] = val
    return shortest[1: s] + shortest[s + 1: -1]


# n = 5
# edges = [[1, 2, 10], [1, 3, 6], [2, 4, 8]]
# s = 2
# print(shortestReach(n, edges, s))
# n2 = 4
# edges2 = [[1, 2, 24], [1, 4, 20], [3, 1, 3], [4, 3, 12]]
# s2 = 1
# print(shortestReach(n2, edges2, s2))
n = 2499

f = open(os.path.dirname(os.path.abspath(__file__)) +
         '/shortest_reach_params.txt', 'r')
edges = []
for a in f:
    u, v, k = a.strip().split(" ")
    edges.append([int(u), int(v), int(k)])
s = 1
print(shortestReach(n, edges, s))


def shortestReachII(n, shortest_dist, s):
    queue = list()
    queue.append(s)

    res = [-1] * (n + 1)
    res[s] = 0

    while queue:
        currentNode = queue.pop(0)

        for neighbor in shortest_dist[currentNode]:
            new_dist = res[currentNode] + shortest_dist[currentNode][neighbor]
            prevDistance = res[neighbor]
            if res[neighbor] == -1:
                res[neighbor] = new_dist
            else:
                res[neighbor] = min(new_dist, res[neighbor])

            if prevDistance != res[neighbor]:
                queue.append(neighbor)

    del res[s]
    del res[0]
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        shortest_dist = [dict() for _ in range(n + 1)]
        for _ in range(m):
            u, v, w = list(map(int, input().rstrip().split()))
            if u not in shortest_dist[v]:
                shortest_dist[u][v] = shortest_dist[v][u] = w
            else:
                shortest_dist[u][v] = shortest_dist[v][u] = min(
                    w, shortest_dist[u][v])

        s = int(input().strip())

        result = shortestReachII(n, shortest_dist, s)

        fptr.write(' '.join(map(str, result)))
        fptr.write('\n')

    fptr.close()
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     t = int(input().strip())

#     for t_itr in range(t):
#         first_multiple_input = input().rstrip().split()

#         n = int(first_multiple_input[0])

#         m = int(first_multiple_input[1])

#         edges = []

#         for _ in range(m):
#             edges.append(list(map(int, input().rstrip().split())))

#         s = int(input().strip())

#         result = shortestReach(n, edges, s)

#         fptr.write(' '.join(map(str, result)))
#         fptr.write('\n')

#     fptr.close()
