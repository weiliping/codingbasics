#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'beadOrnaments' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY b as parameter.
#

MOD = 10 ** 9 + 7


def beadOrnaments(b):
    # Write your code here
    if len(b) == 0:
        return 0

    if len(b) == 1:
        return ((b[0] ** (b[0] - 2)) % MOD)
    res, s_sum = 1, 0
    for v in b:
        res *= v ** (v - 1)
        s_sum += v
    res *= s_sum ** (len(b) - 2)
    return res % MOD


print(beadOrnaments([2]))  # 1
print(beadOrnaments([2, 2]))  # 4
print(beadOrnaments([3, 5, 3]))  # 556875
print(beadOrnaments([3, 4, 3]))  # 51840
print(beadOrnaments([5, 3]))  # 5625

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     t = int(input().strip())

#     for t_itr in range(t):
#     b_count = int(input().strip())

#     b = list(map(int, input().rstrip().split()))

#     result = beadOrnaments(b)

#     fptr.write(str(result) + '\n')

#     fptr.close()
