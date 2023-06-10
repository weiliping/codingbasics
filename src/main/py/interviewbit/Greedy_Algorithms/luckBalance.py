#!/bin/python3

import math
import os
import random
import re
import sys
import heapq
#
# Complete the 'luckBalance' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. 2D_INTEGER_ARRAY contests
#


def luckBalance(k, contests):
    # Write your code here
    s, n = 0, len(contests)
    q = []
    for i in range(n):
        c = contests[i]
        if c[1] == 0:
            s += c[0]
            continue
        if k > 0:
            if len(q) < k:
                heapq.heappush(q, c[0])
                continue
            if q[0] < c[0]:
                s -= heapq.heappop(q)
                heapq.heappush(q, c[0])
                continue
        s -= c[0]
    for num in q:
        s += num
    return s


contests = [[9709, 1], [9704, 1], [9080, 1], [9060, 1], [9467, 1], [9847, 1], [9590, 1], [9225, 1], [9304, 1], [9527, 1], [9329, 1], [9962, 1], [9928, 1], [9525, 1], [9491, 1], [9993, 1], [9829, 1], [9153, 1], [9936, 1], [9899, 1], [9312, 1], [9862, 1], [9610, 1], [9502, 1], [9522, 1], [9359, 1], [9617, 1], [9431, 1], [9757, 1], [9292, 1], [9875, 1], [9041, 1], [9626, 1], [9656, 1], [9893, 1], [9442, 1], [9369, 1], [9282, 1], [9117, 1], [9245, 1], [9841, 1], [9715, 1], [9778, 1], [9150, 1], [9738, 1], [9699, 1], [9642, 1], [9517, 1], [9407, 1], [
    9675, 1], [9918, 1], [9031, 1], [9369, 1], [9935, 1], [9868, 1], [9934, 1], [9660, 1], [9931, 1], [9273, 1], [9168, 1], [9404, 1], [9017, 1], [9288, 1], [9532, 1], [9700, 1], [9291, 1], [9126, 1], [9782, 1], [9545, 1], [9076, 1], [9346, 1], [9018, 1], [9732, 1], [9032, 1], [9992, 1], [9630, 1], [9952, 1], [9885, 1], [9328, 1], [9419, 1], [9705, 1], [9611, 1], [9440, 1], [9907, 1], [9303, 1], [9449, 1], [9876, 1], [9335, 1], [9723, 1], [9698, 1], [9823, 1], [9070, 1], [9258, 1], [9102, 1], [9370, 1], [9788, 1], [9725, 1], [9811, 1], [9474, 1], [9602, 1]]
print(luckBalance(0, contests))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     k = int(first_multiple_input[1])

#     contests = []

#     for _ in range(n):
#         contests.append(list(map(int, input().rstrip().split())))

#     result = luckBalance(k, contests)

#     fptr.write(str(result) + '\n')

#     fptr.close()
