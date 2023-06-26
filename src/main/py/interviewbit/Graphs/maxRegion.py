#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'maxRegion' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY grid as parameter.
#


def maxRegion(grid):
    # Write your code here
    n, m = len(grid), len(grid[0])
    dirs = [[-1, -1], [-1, 0], [-1, 1], [0, -1],
            [0, 1], [1, -1], [1, 0], [1, 1]]
    res = 0

    def dfsHelper(i, j, n, m, grid, v, dirs):
        if i < 0 or i >= n or j < 0 or j >= m or grid[i][j] == 0:
            return
        if grid[i][j] == 1:
            v[0] += 1
            grid[i][j] = 0
        for d in dirs:
            dfsHelper(i + d[0], j + d[1], n, m, grid, v, dirs)
    for i in range(n):
        for j in range(m):
            if grid[i][j] == 1:
                v = [0]
                dfsHelper(i, j, n, m, v, dirs)
                res = max(res, v[0])
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    m = int(input().strip())

    grid = []

    for _ in range(n):
        grid.append(list(map(int, input().rstrip().split())))

    res = maxRegion(grid)

    fptr.write(str(res) + '\n')

    fptr.close()
