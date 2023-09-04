#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'morganAndString' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
#


def morganAndStringI(a, b):
    def morganStr(a, b):
        n = len(a) + len(b)
        a += 'z'
        b += 'z'
        for _ in range(n):
            if a < b:
                yield a[0]
                a = a[1:]
            else:
                yield b[0]
                b = b[1:]

    return ''.join(morganStr(a, b))


def morganAndString(a, b):
    # Write your code here
    n, m = len(a), len(b)
    i, j = 0, 0
    str = ''
    while i < n and j < m:
        if a[i] < b[j]:
            str += a[i]
            i += 1
        else:
            str += b[j]
            j += 1
    if i < n:
        str += a[i:]
    if j < m:
        str += b[j:]
    return str


print(morganAndStringI("JACK", "DANIEL"))
# print(morganAndString("JACK", "DANIEL"))
# print(morganAndString("ABACABA", "ABACABA"))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     t = int(input().strip())

#     for t_itr in range(t):
#         a = input()

#         b = input()

#         result = morganAndString(a, b)

#         fptr.write(result + '\n')

#     fptr.close()
