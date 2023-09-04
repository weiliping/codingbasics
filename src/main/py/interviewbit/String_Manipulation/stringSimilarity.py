#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'stringSimilarity' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#


def stringSimilarity(s):
    # Write your code here
    n = len(s)
    inds = []
    for i in range(1, n):
        if s[0] == s[i]:
            inds.append(i)
    cnt = n
    for i in inds:
        j = i
        while j < n and s[j] == s[j - i]:
            cnt += 1
            j += 1
    return cnt


def stringSimilarityI(s):
    n = len(s)
    z = [0] * n
    l, r = 0, 0
    for i in range(1, n):
        if i > r:
            l, r = i, i
            while r < n and s[r - l] == s[r]:
                r += 1
            z[i] = r - l
            r -= 1
        else:
            k = i - l
            if z[k] < r - i + 1:
                z[i] = z[k]
            else:
                l = i
                while r < n and s[r - l] == s[r]:
                    r += 1
                z[i] = r - l
                r -= 1
    return sum(z) + n


print(stringSimilarityI("ababaa"))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     t = int(input().strip())

#     for t_itr in range(t):
#         s = input()

#         result = stringSimilarity(s)

#         fptr.write(str(result) + '\n')

#     fptr.close()
