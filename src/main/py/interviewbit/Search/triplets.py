#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the triplets function below.


def triplets(a, b, c):
    from bisect import bisect
    a = list(dict.fromkeys(a))
    c = list(dict.fromkeys(c))
    a.sort()
    c.sort()
    s = set()
    res = 0
    for num in b:
        if num in s:
            continue
        s.add(num)
        c1 = bisect(a, num)
        if c1 == 0:
            continue
        c2 = bisect(c, num)
        res += c1 * c2
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    lenaLenbLenc = input().split()

    lena = int(lenaLenbLenc[0])

    lenb = int(lenaLenbLenc[1])

    lenc = int(lenaLenbLenc[2])

    arra = list(map(int, input().rstrip().split()))

    arrb = list(map(int, input().rstrip().split()))

    arrc = list(map(int, input().rstrip().split()))

    ans = triplets(arra, arrb, arrc)

    fptr.write(str(ans) + '\n')

    fptr.close()
