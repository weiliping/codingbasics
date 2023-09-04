#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'renameFile' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. STRING newName
#  2. STRING oldName
#

def renameFile(newName, oldName):
    # Write your code here
    MAX_V = 10**9 + 7
    m, n = len(newName), len(oldName)
    dp = [[0 for _ in range(n)] for _ in range(m)]
    if newName[0] == oldName[0]:
        dp[0][0] = 1

    for j in range(1, n):
        if oldName[j] == newName[0]:
            dp[0][j] = dp[0][j - 1] + 1
        else:
            dp[0][j] = dp[0][j - 1]
    for i in range(1, m):
        if oldName[i] == newName[i]:
            dp[i][i] = 1

    for i in range(1, m):
        for j in range(i + 1, n):
            if newName[i] == oldName[j]:
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]
                if dp[i][j] > MAX_V:
                    dp[i][j] %= MAX_V
            else:
                dp[i][j] = dp[i][j - 1]
    return dp[m - 1][n - 1]


print(renameFile("aba", "ababa"))
print(renameFile("ccc", "cccc"))

print(renameFile("abc", "aaabbbccc"))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     newName = input()

#     oldName = input()

#     result = renameFile(newName, oldName)

#     fptr.write(str(result) + '\n')

#     fptr.close()
