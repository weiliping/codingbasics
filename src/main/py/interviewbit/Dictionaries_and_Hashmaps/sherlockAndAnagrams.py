#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'sherlockAndAnagrams' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#


cnts = [0, 0, 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, 66, 78, 91, 105, 120, 136, 153, 171, 190, 210, 231, 253, 276, 300, 325, 351, 378, 406, 435, 465, 496, 528, 561, 595, 630, 666, 703, 741, 780, 820, 861, 903, 946, 990, 1035, 1081, 1128, 1176, 1225, 1275, 1326, 1378, 1431,
        1485, 1540, 1596, 1653, 1711, 1770, 1830, 1891, 1953, 2016, 2080, 2145, 2211, 2278, 2346, 2415, 2485, 2556, 2628, 2701, 2775, 2850, 2926, 3003, 3081, 3160, 3240, 3321, 3403, 3486, 3570, 3655, 3741, 3828, 3916, 4005, 4095, 4186, 4278, 4371, 4465, 4560, 4656, 4753, 4851, 4950]


def sherlockAndAnagrams(s):
    # Write your code here
    n = len(s)
    sums, chrs = [[0 for i in range(26)]
                  for j in range(n + 1)], [0 for i in range(26)]
    cInd, dict = 1, {}
    for ch in s:
        chrs[ord(ch) - ord('a')] += 1
        dict[ch] = dict.get(ch, 0) + 1
        sums[cInd] = chrs.copy()
        cInd += 1
    i = 2
    while i < n:
        for j in range(n - i + 1):
            strK = ''
            p = sums[i + j]
            q = sums[j]
            for k in range(26):
                diff = p[k] - q[k]
                if diff > 0:
                    strK += chr(ord('a') + k) + str(diff)
            dict[strK] = dict.get(strK, 0) + 1
        i += 1
    res = 0
    for v in dict.values():
        if v >= 2:
            res += cnts[v]
    return res


print(sherlockAndAnagrams('abba'))
print(sherlockAndAnagrams('abcd'))
print(sherlockAndAnagrams('ifailuhkqq'))
print(sherlockAndAnagrams('kkkk'))
print(sherlockAndAnagrams('cdcd'))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         s = input()

#         result = sherlockAndAnagrams(s)

#         fptr.write(str(result) + '\n')

#     fptr.close()
