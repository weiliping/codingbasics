#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'stepPerms' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER n as parameter.
#
dp = [0] * 37
e = 10**10 + 7

dp[0] = 1


def stepPerms(n):
    # Write your code here
    if dp[n] != 0:
        return dp[n]
    if n < 3:
        dp[n] = n
        return dp[n]
    else:
        dp[n] = stepPerms(n - 1) + stepPerms(n - 2) + stepPerms(n - 3)
        if dp[n] > e:
            dp[n] %= e
        return dp[n]


print(stepPerms(36))
print(dp)
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     s = int(input().strip())

#     for s_itr in range(s):
#         n = int(input().strip())

#         res = stepPerms(n)

#         fptr.write(str(res) + '\n')

#     fptr.close()
