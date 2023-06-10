#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'alternatingCharacters' function below.
#
# The function is expected to return an INTEGER.
# The function accepts STRING s as parameter.
#


def alternatingCharacters(s):
    # Write your code here
    preChr = s[0]
    cnt = 0
    for j in range(1, len(s), 1):
        if preChr == s[j]:
            cnt += 1
            continue
        preChr = s[j]
    return cnt


print(alternatingCharacters('AAAA'))
print(alternatingCharacters('BBBBB'))
print(alternatingCharacters('ABABABAB'))
print(alternatingCharacters('BABABA'))
print(alternatingCharacters('AAABBB'))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     q = int(input().strip())

#     for q_itr in range(q):
#         s = input()

#         result = alternatingCharacters(s)

#         fptr.write(str(result) + '\n')

#     fptr.close()
