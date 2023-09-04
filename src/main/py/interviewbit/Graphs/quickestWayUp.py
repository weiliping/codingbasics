#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'quickestWayUp' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. 2D_INTEGER_ARRAY ladders
#  2. 2D_INTEGER_ARRAY snakes
#


def quickestWayUp(ladders, snakes):
    # Write your code here
    lad_m = {k: v for k, v in ladders}
    for k, v in snakes:
        lad_m[k] = v
    q = []
    q.append([1, 0])
    MAX_V = 10**4
    visited = [False for _ in range(101)]
    visited[1] = True
    while len(q) > 0:
        pos, roll = q.pop(0)
        if pos == 100:
            return roll
        for step in range(1, 7):
            next_pos = pos + step
            if next_pos > 100:
                continue
            next_roll = roll + 1
            if next_pos == 100:
                return next_roll
            if next_pos in lad_m.keys():
                if not visited[lad_m[next_pos]]:
                    visited[lad_m[next_pos]] = True
                    q.append([lad_m[next_pos], next_roll])
                continue
            if not visited[next_pos]:
                visited[next_pos] = True
                q.append([next_pos, next_roll])
    return -1


# ladders = [[32, 62], [42, 68], [12, 98]]
# snakes = [[95, 13], [97, 25], [93, 37], [79, 27], [75, 19], [49, 47], [67, 17]]
# print(quickestWayUp(ladders, snakes))
# ladders1 = [[3, 54], [37, 100]]
# snakes1 = [[56, 33]]
# print(quickestWayUp(ladders1, snakes1))

# ladders2 = [[3, 5], [7, 8], [44, 56], [36, 54], [88, 91],
#             [77, 83], [2, 4], [9, 99], [45, 78], [31, 75]]
# snakes2 = [[10, 6], [95, 90], [96, 30], [97, 52], [98, 86]]
# print(quickestWayUp(ladders2, snakes2))
ladders2 = [[5, 6]]
snakes2 = [[97, 95]]
print(quickestWayUp(ladders2, snakes2))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     t = int(input().strip())

#     for t_itr in range(t):
#         n = int(input().strip())

#         ladders = []

#         for _ in range(n):
#             ladders.append(list(map(int, input().rstrip().split())))

#         m = int(input().strip())

#         snakes = []

#         for _ in range(m):
#             snakes.append(list(map(int, input().rstrip().split())))

#         result = quickestWayUp(ladders, snakes)

#         fptr.write(str(result) + '\n')

#     fptr.close()
