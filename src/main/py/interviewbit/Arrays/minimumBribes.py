#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'minimumBribes' function below.
#
# The function accepts INTEGER_ARRAY q as parameter.
#


def minimumBribes(q):
    # Write your code here
    n = len(q)
    cnt = 0
    isChaotic = False
    for i in range(n - 1, -1, -1):
        if q[i] == i + 1:
            continue
        if q[i - 1] == i + 1:
            cnt += 1
            swap(q, i - 1, i)
        elif q[i - 2] == i + 1:
            cnt += 2
            swap(q, i - 2, i - 1)
            swap(q, i - 1, i)
        else:
            print("Too chaotic")
            isChaotic = True
            break
    if not isChaotic:
        print(cnt)


def swap(q, i, j):
    t = q[i]
    q[i] = q[j]
    q[j] = t


if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)
