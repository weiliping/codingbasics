#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'roadsAndLibraries' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER c_lib
#  3. INTEGER c_road
#  4. 2D_INTEGER_ARRAY cities
#


def roadsAndLibraries(n, c_lib, c_road, cities):
    # Write your code here
    if c_lib <= c_road:
        return n * c_lib
    g = [[] for _ in range(n)]
    for e in cities:
        i, j = e[0] - 1, e[1] - 1
        g[i].append(j)
        g[j].append(i)
    visited = [False for _ in range(n)]

    m = 0
    for i in range(n):
        if visited[i]:
            continue
        q = []
        q.append(i)
        visited[i] = True
        m += c_lib
        while len(q) > 0:
            city = q.pop(0)
            for child in g[city]:
                if not visited[child]:
                    q.append(child)
                    m += c_road
                    visited[child] = True
    return m


print(roadsAndLibraries(3, 2, 1, [[1, 2], [3, 1], [2, 3]]))
# print(roadsAndLibraries(
#     6, 2, 5, [[1, 3], [3, 4], [2, 4], [1, 2], [2, 3], [5, 6]]))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         first_multiple_input = input().rstrip().split()

#         n = int(first_multiple_input[0])

#         m = int(first_multiple_input[1])

#         c_lib = int(first_multiple_input[2])

#         c_road = int(first_multiple_input[3])

#         cities = []

#         for _ in range(m):
#             cities.append(list(map(int, input().rstrip().split())))

#         result = roadsAndLibraries(n, c_lib, c_road, cities)

#         fptr.write(str(result) + '\n')

#     fptr.close()
