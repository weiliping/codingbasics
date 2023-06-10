#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'superDigit' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING n
#  2. INTEGER k
#


def superDigit(n, k):
    # Write your code here
    sum = 0
    for a in n:
        sum += int(a)
    return helper(sum * k)


def helper(num):
    if num < 10:
        return num
    sum = 0
    while num > 0:
        sum += num % 10
        num //= 10
    return helper(sum)


print(superDigit('9875', 4))
print(superDigit('148', 3))
print(superDigit('123', 3))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = first_multiple_input[0]

#     k = int(first_multiple_input[1])

#     result = superDigit(n, k)

#     fptr.write(str(result) + '\n')

#     fptr.close()
