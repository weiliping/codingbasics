#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'decibinaryNumbers' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts LONG_INTEGER x as parameter.
#

MAX_D = 3
MAX_C = 63
f = [[0 for _ in range(MAX_C + 1)] for _ in range(MAX_D + 1)]
sum_f = [0 for _ in range(MAX_C + 1)]

f[0][0] = 1


def buildF():
    for i in range(1, MAX_D + 1):
        d = (1 << (i - 1))
        for j in range(MAX_C + 1):
            for k in range(10):
                prev_j = j - k * d
                if prev_j >= 0:
                    f[i][j] += f[i - 1][prev_j]


def buildSumF():
    s_num = 0
    for i in range(MAX_C + 1):
        s_num += f[MAX_D][i]
        sum_f[i] = s_num


buildF()
buildSumF()


def decibinaryNumbers(x):
    deci_x = binarySearch(sum_f, x)
    pos = x - (0 if deci_x == 0 else sum_f[deci_x - 1])
    res = 0
    for i in range(MAX_D, 0, -1):
        print(deci_x, pos)
        print(f[i - 1])
        j = -1
        pre_num, curr_num, d = -1, 0, 1 << (i - 1)

        while curr_num < pos:
            j += 1
            pre_num = curr_num
            k = deci_x - j * d
            print(j * d, k, f[i - 1][k])
            curr_num += f[i - 1][k]
        res = res * 10 + j
        deci_x -= j * d
        pos -= pre_num
    return res


def binarySearch(nums, x):
    l, r = 0, len(nums)
    while l < r:
        mid = l + ((r - l) >> 1)
        if nums[mid] < x:
            l = mid + 1
        else:
            r = mid
    return r


# print(decibinaryNumbers(6))
# print(decibinaryNumbers(7))
# print(decibinaryNumbers(8))
# print(decibinaryNumbers(9))
# for i in range(11, 15):
print(decibinaryNumbers(20))
# print(decibinaryNumbers(8))  # 12
# print(decibinaryNumbers(23))  # 23
# print(decibinaryNumbers(19))  # 102
# print(decibinaryNumbers(16))  # 14
# print(decibinaryNumbers(26))  # 111
# print(decibinaryNumbers(7))  # 4
# print(decibinaryNumbers(6))  # 11

# print(decibinaryNumbers(23))
# print(decibinaryNumbers(19))
# print(decibinaryNumbers(16))
# print(decibinaryNumbers(26))
# print(decibinaryNumbers(7))
# print(decibinaryNumbers(6))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         x = int(input().strip())

#         result = decibinaryNumbers(x)

#         fptr.write(str(result) + '\n')

#     fptr.close()
