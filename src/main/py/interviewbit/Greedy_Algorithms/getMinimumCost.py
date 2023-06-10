#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the getMinimumCost function below.


def getMinimumCost(k, c):
    c.sort()
    s, n = 0, len(c)
    for j in range(n):
        ind = n - 1 - j
        prev = j // k
        s += (prev + 1) * c[ind]
    return s


print(getMinimumCost(3, [2, 5, 6]))
print(getMinimumCost(2, [2, 5, 6]))
print(getMinimumCost(3, [1, 3, 5, 7, 9]))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     nk = input().split()

#     n = int(nk[0])

#     k = int(nk[1])

#     c = list(map(int, input().rstrip().split()))

#     minimumCost = getMinimumCost(k, c)

#     fptr.write(str(minimumCost) + '\n')

#     fptr.close()
