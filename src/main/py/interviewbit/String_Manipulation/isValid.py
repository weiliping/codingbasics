#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isValid' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#


def isValid(s):
    # Write your code here
    dp = [0 for i in range(26)]
    for a in s:
        dp[ord(a) - ord('a')] += 1
    cnt = {}
    for i in range(26):
        if dp[i] != 0:
            cnt[dp[i]] = cnt.get(dp[i], 0) + 1
    l = len(cnt.keys())
    if l > 2:
        return 'NO'
    if l == 1:
        return 'YES'
    if l == 2:
        ks = list(cnt.keys())
        k0, k1 = ks[0], ks[1]
        if cnt.get(k0) < cnt.get(k1):
            t = k1
            k1 = k0
            k0 = t
        if cnt.get(k1) == 1 and (k1 == 1 or k0 + 1 == k1):
            return 'YES'
    return 'NO'


print(isValid('aabbc'))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     s = input()

#     result = isValid(s)

#     fptr.write(result + '\n')

#     fptr.close()
