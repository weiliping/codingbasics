#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'candies' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. INTEGER_ARRAY arr
#


def candies(n, arr):
    # Write your code here
    preDp = [0 for i in range(n)]
    i = 0
    while i < n:
        preDp[i] = 1
        j = i
        while j < n - 1 and arr[j] < arr[j + 1]:
            preDp[j + 1] = preDp[j] + 1
            j += 1
        i = j + 1
    suffDp = [0 for j in range(n)]
    j = n - 1
    while j > -1:
        suffDp[j] = 1
        i = j
        while i > 0 and arr[i - 1] > arr[i]:
            suffDp[i - 1] = suffDp[i] + 1
            i -= 1
        j = i - 1
    res = 0
    for k in range(n):
        res += max(preDp[k], suffDp[k])
    return res


print(candies(3, [1, 2, 2]))
print(candies(10, [2, 4, 2, 6, 1, 7, 8, 9, 2, 1]))
print(candies(8, [2, 4, 3, 5, 2, 6, 4, 5]))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    arr = []

    for _ in range(n):
        arr_item = int(input().strip())
        arr.append(arr_item)

    result = candies(n, arr)

    fptr.write(str(result) + '\n')

    fptr.close()
