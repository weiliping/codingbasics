#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'connectedCell' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY matrix as parameter.
#


def connectedCell(matrix):
    # Write your code here
    cnt, m, n = 0, len(matrix), len(matrix[0])
    for i in range(m):
        for j in range(n):
            if matrix[i][j] == 1:
                sub = [1]
                matrix[i][j] = 0
                connectHelper(i, j, matrix, m, n, sub)
                cnt = max(cnt, sub[0])
    return cnt


def connectHelper(i, j, matrix, m, n, res):
    if i + 1 < m and matrix[i + 1][j] == 1:
        res[0] += 1
        matrix[i + 1][j] = 0
        connectHelper(i + 1, j, matrix, m, n, res)
    if i - 1 >= 0 and matrix[i - 1][j] == 1:
        res[0] += 1
        matrix[i - 1][j] = 0
        connectHelper(i - 1, j, matrix, m, n, res)
    if j + 1 < n and matrix[i][j + 1] == 1:
        res[0] += 1
        matrix[i][j + 1] = 0
        connectHelper(i, j + 1, matrix, m, n, res)
    if j - 1 >= 0 and matrix[i][j - 1] == 1:
        res[0] += 1
        matrix[i][j - 1] = 0
        connectHelper(i, j - 1, matrix, m, n, res)
    if j - 1 >= 0 and i - 1 >= 0 and matrix[i - 1][j - 1] == 1:
        res[0] += 1
        matrix[i - 1][j - 1] = 0
        connectHelper(i - 1, j - 1, matrix, m, n, res)
    if j - 1 >= 0 and i + 1 < m and matrix[i + 1][j - 1] == 1:
        res[0] += 1
        matrix[i + 1][j - 1] = 0
        connectHelper(i + 1, j - 1, matrix, m, n, res)
    if j + 1 < n and i + 1 < m and matrix[i + 1][j + 1] == 1:
        res[0] += 1
        matrix[i + 1][j + 1] = 0
        connectHelper(i + 1, j + 1, matrix, m, n, res)
    if j - 1 >= 0 and i + 1 < m and matrix[i + 1][j - 1] == 1:
        res[0] += 1
        matrix[i + 1][j - 1] = 0
        connectHelper(i + 1, j - 1, matrix, m, n, res)


# matrix = [[0, 0, 1, 1], [0, 0, 1, 0], [0, 1, 1, 0], [0, 1, 0, 0], [1, 1, 0, 0]]
matrix = [[0, 1, 1, 1, 1], [1, 0, 0, 0, 1], [
    1, 1, 0, 1, 0], [0, 1, 0, 1, 1], [0, 1, 1, 1, 0]]
print(connectedCell(matrix))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input().strip())

#     m = int(input().strip())

#     matrix = []

#     for _ in range(n):
#         matrix.append(list(map(int, input().rstrip().split())))

#     result = connectedCell(matrix)

#     fptr.write(str(result) + '\n')

#     fptr.close()
