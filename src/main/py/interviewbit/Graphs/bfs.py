#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'bfs' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER m
#  3. 2D_INTEGER_ARRAY edges
#  4. INTEGER s
#


def bfs(n, m, edges, s):
    # Write your code here
    res = [-1 for _ in range(n + 1)]
    g = [[] for _ in range(n + 1)]
    for j in range(m):
        g[edges[j][0]].append(edges[j][1])
        g[edges[j][1]].append(edges[j][0])
    q = [[s, 0]]
    visited = [False for _ in range(n + 1)]
    visited[s] = True
    while q:
        p = q.pop(0)
        for c in g[p[0]]:
            if visited[c]:
                continue
            l = p[1] + 1
            res[c] = 6 * l
            q.append([c, l])
            visited[c] = True
    del (res[s])
    del (res[0])
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    for q_itr in range(q):
        first_multiple_input = input().rstrip().split()

        n = int(first_multiple_input[0])

        m = int(first_multiple_input[1])

        edges = []

        for _ in range(m):
            edges.append(list(map(int, input().rstrip().split())))

        s = int(input().strip())

        result = bfs(n, m, edges, s)

        fptr.write(' '.join(map(str, result)))
        fptr.write('\n')

    fptr.close()
