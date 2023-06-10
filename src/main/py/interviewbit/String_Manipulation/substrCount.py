#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the substrCount function below.


def substrCount(n, s):
    cnt = n
    i = 0
    while i < n:
        j = i
        while j < n - 1 and s[i] == s[j + 1]:
            j += 1
        if j > i:
            l = j - i + 1
            cnt += getNum(l)
            midInt = j + 1
            k = midInt
            while k < n - 1 and s[i] == s[k + 1]:
                k += 1
            if k == midInt:
                i = midInt
                continue
            r = k - midInt
            cnt += min(l, r)
            i = midInt
            continue
        k = j + 2
        if k < n and s[i] == s[k]:
            cnt += 1
        i += 1
    return cnt


def getNum(n):
    return (n * (n - 1)) >> 1


print(substrCount(len('asasd'), 'asasd'))
print(substrCount(len('aaasd'), 'aaasd'))
print(substrCount(len('aaaaaas'), 'aaaaaas'))
print(substrCount(len('aaasaa'), 'aaasaa'))
# print(substrCount(len('aaasaaaa'), 'aaasaaaa'))
# print(substrCount(len('aaasaaaadd'), 'aaasaaaadd'))
# print(substrCount(len('aaasaaaadaaaaa'), 'aaasaaaadaaaaa'))
# print(substrCount(len('ddaafddfffefff'), 'ddaafddfffefff'))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input())

#     s = input()

#     result = substrCount(n, s)

#     fptr.write(str(result) + '\n')

#     fptr.close()
