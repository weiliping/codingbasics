#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'makeAnagram' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
#


def makeAnagram(a, b):
    # Write your code here
    dp = [0 for i in range(26)]

    for c in a:
        dp[ord(c) - ord('a')] += 1

    cnt = 0
    for c in b:
        j = ord(c) - ord('a')
        if dp[j] > 0:
            dp[j] -= 1
        else:
            cnt += 1
    cnt += sum(dp)
    return cnt


# print(makeAnagram('bacdc', 'dcbac'))
print(makeAnagram('cde', 'dcf'))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     a = input()

#     b = input()

#     res = makeAnagram(a, b)

#     fptr.write(str(res) + '\n')

#     fptr.close()
