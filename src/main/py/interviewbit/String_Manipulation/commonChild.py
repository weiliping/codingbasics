#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'commonChild' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING s1
#  2. STRING s2
#


def commonChild(s1, s2):
    # Write your code here
    m, n = len(s1), len(s2)
    dp = [[0 for i in range(m)] for j in range(n)]

    if s1[0] == s2[0]:
        dp[0][0] = 1
    for i in range(1, m, 1):
        if s1[i] == s2[0]:
            dp[i][0] = 1
        else:
            dp[i][0] = dp[i - 1][0]
    for j in range(1, n, 1):
        if s1[0] == s2[j]:
            dp[0][j] = 1
        else:
            dp[0][j] = dp[0][j - 1]
    maxCnt = 0
    for i in range(1, m, 1):
        for j in range(1, n, 1):
            if s1[i] == s2[j]:
                dp[i][j] = dp[i - 1][j - 1] + 1
                dp[i][j] = max(dp[i][j], dp[i - 1][j], dp[i][j - 1])
                maxCnt = max(maxCnt, dp[i][j])
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    return maxCnt

# print(commonChild('HARRY', 'SALLY'))
# print(commonChild('SHINCHAN', 'NOHARAAA'))


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    s1 = input()

    s2 = input()

    result = commonChild(s1, s2)

    fptr.write(str(result) + '\n')

    fptr.close()
