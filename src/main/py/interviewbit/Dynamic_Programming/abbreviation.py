#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'abbreviation' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING a
#  2. STRING b
#


def abbreviation(a, b):
    # Write your code here
    m, n = len(a), len(b)
    dp = [[0 for i in range(m + 1)] for j in range(n + 1)]

    for j in range(n):
        for i in range(m):
            if b[j] == a[i]:
                dp[j + 1][i + 1] = dp[j][i] + 1
                continue
            if a[i].islower():
                if b[j] == a[i].upper():
                    dp[j + 1][i + 1] = max(dp[j][i] + 1, dp[j + 1][i])
                else:
                    dp[j + 1][i + 1] = dp[j + 1][i]
    return 'YES' if dp[n][m] == n else 'NO'


print(abbreviation('EFYyxu', 'EFY'))
# print(abbreviation('AbcDE', 'ABDE'))
# print(abbreviation('AbcDE', 'AFDE'))
# print(abbreviation('daBcd', 'ABC'))
# print(abbreviation('beFgH', 'EFG'))
# print(abbreviation('XXVVnDEFYgYeMXzWINQYHAQKKOZEYgSRCzLZAmUYGUGILjMDET',
#   'XXVVDEFYYMXWINQYHAQKKOZEYSRCLZAUYGUGILMDETQVWU'))  # NO
# print(abbreviation('PVJSNVBDXABZYYGIGFYDICWTFUEJMDXADhqcbzva',
#   'PVJSNVBDXABZYYGIGFYDICWTFUEJMDXAD'))  # YES

# print(abbreviation('QOTLYiFECLAGIEWRQMWPSMWIOQSEBEOAuhuvo',
#       'QOTLYFECLAGIEWRQMWPSMWIOQSEBEOA'))  # YES
# print(abbreviation('DRFNLZZVHLPZWIupjwdmqafmgkg', 'DRFNLZZVHLPZWI'))  # YES
# print(abbreviation('SLIHGCUOXOPQYUNEPSYVDaEZKNEYZJUHFXUIL',
#       'SLIHCUOXOPQYNPSYVDEZKEZJUHFXUIHMGFP'))  # NO
# print(abbreviation('RYASPJNZEFHEORROXWZFOVDWQCFGRZLWWXJVMTLGGnscruaa',
#       'RYASPJNZEFHEORROXWZFOVDWQCFGRZLWWXJVMTLGG'))  # YES
# print(abbreviation('AVECtLVOXKPHIViTZViLKZCZAXZUZRYZDSTIHuCKNykdduywb',
#       'AVECLVOXKPHIVTZVLKZCZAXZUZRYZDSTIHCKN'))  # YES
# print(abbreviation('wZPRSZwGIMUAKONSVAUBUgSVPBWRSTJZECxMTQXXA',
#       'ZPRSZGIMUAKONSVAUBUSVPBWRSTJZECMTQXXA'))  # YES
# print(abbreviation('SYIHDDSMREKXOKRFDQAOZJQXRIDWXPYINFZCEFYyxu',
#   'SYIHDDSMREKXOKRFDQAOZJQXRIDWXPYINFZCEFY'))  # YES
# print(abbreviation('EIZGAWWDCSJBBZPBYVNKRDEWVZnSSWZIw',
#   'EIZGAWWDCSJBBZPBYVNKRDEWVZSSWZI'))  # YES
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         a = input()

#         b = input()

#         result = abbreviation(a, b)

#         fptr.write(result + '\n')

#     fptr.close()
