#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumMoves' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING_ARRAY grid
#  2. INTEGER startX
#  3. INTEGER startY
#  4. INTEGER goalX
#  5. INTEGER goalY
#


def minimumMoves(grid, startX, startY, goalX, goalY):
    # Write your code here
    class Node:
        def __init__(self, x, y, s):
            self.x = x
            self.y = y
            self.s = s

    m, n = len(grid), len(grid[0])
    q, visited = [], [[False for _ in range(n)] for _ in range(m)]
    q.append(Node(startX, startY, 0))
    while len(q) > 0:
        p = q.pop(0)
        if p.x == goalX and p.y == goalY:
            return p.s
        if visited[p.x][p.y]:
            continue
        visited[p.x][p.y] = True
        s = p.s + 1
        for l in range(p.y, -1, -1):
            if grid[p.x][l] == 'X':
                break
            if visited[p.x][l]:
                continue
            q.append(Node(p.x, l, s))
        for r in range(p.y, n):
            if grid[p.x][r] == 'X':
                break
            if visited[p.x][r]:
                continue
            q.append(Node(p.x, r, s))

        for u in range(p.x, -1, -1):
            if grid[u][p.y] == 'X':
                break
            if visited[u][p.y]:
                continue
            q.append(Node(u, p.y, s))

        for d in range(p.x, m):
            if grid[d][p.y] == 'X':
                break
            if visited[d][p.y]:
                continue
            q.append(Node(d, p.y, s))
    return -1


# f = open(os.path.dirname(os.path.abspath(__file__)) + '/params.txt', 'r')
# dp = []
# for a in f:
#     dp.append(a.strip())
# print(minimumMoves(dp, 34, 28, 16, 8))
print(minimumMoves(['.X.', '.X.', '...'], 0, 0, 0, 2))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(p.input().strip())

#     grid = []

#     for _ in range(n):
#         grid_item = input()
#         grid.append(grid_item)

#     first_multiple_input = input().rstrip().split()

#     startX = int(first_multiple_input[0])

#     startY = int(first_multiple_input[1])

#     goalX = int(first_multiple_input[2])

#     goalY = int(first_multiple_input[3])

#     result = minimumMoves(grid, startX, startY, goalX, goalY)

#     fptr.write(str(result) + '\n')

#     fptr.close()
