#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'pairs' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER k
#  2. INTEGER_ARRAY arr
#


def pairs(k, arr):
    # Write your code here
    s = set()
    res = 0
    for a in arr:
        t = a + k
        if t in s:
            res += 1
        if a > k:
            t = a - k
            if t in s:
                res += 1
        s.add(a)
    return res


print(pairs(2, [1, 5, 3, 4, 2]))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     k = int(first_multiple_input[1])

#     arr = list(map(int, input().rstrip().split()))

#     result = pairs(k, arr)

#     fptr.write(str(result) + '\n')

#     fptr.close()
