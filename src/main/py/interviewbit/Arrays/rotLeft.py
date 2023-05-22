#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'rotLeft' function below.
#
# The function is expected to return an INTEGER_ARRAY.
# The function accepts following parameters:
#  1. INTEGER_ARRAY a
#  2. INTEGER d
#


def rotLeft(a, d):
    # Write your code here
    n = len(a)
    d %= n
    if d == 0:
        return a
    b = []
    m = n - d
    for i in range(n):
        if i < d:
            b.append(a[i])
        else:
            a[i - d] = a[i]
    for i in range(d):
        a[m + i] = b[i]
    return a


for i in range(30):
    print(rotLeft([1, 2, 3, 4, 5, 6, 7, 8, 9], i))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     d = int(first_multiple_input[1])

#     a = list(map(int, input().rstrip().split()))

#     result = rotLeft(a, d)

#     fptr.write(' '.join(map(str, result)))
#     fptr.write('\n')

#     fptr.close()
