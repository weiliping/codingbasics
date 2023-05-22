import math
import os
import random
import re
import sys

#
# Complete the 'countSwaps' function below.
#
# The function accepts INTEGER_ARRAY a as parameter.
#


def countSwaps(a):
    # Write your code here
    n = len(a)
    swapCnt, l, r = 0, n, -1
    for i in range(n):
        for j in range(n - i - 1):
            if a[j] > a[j + 1]:
                swapCnt += 1
                if l > j:
                    l = j
                if r < j + 1:
                    r = j + 1
                swap(a, j, j + 1)

    print('Array is sorted in', swapCnt, 'swaps. ')
    if swapCnt == 0:
        l, r = 0, n - 1
    print('First Element:', a[l])
    print('Last Element:', a[r])


def swap(a, i, j):
    t = a[i]
    a[i] = a[j]
    a[j] = t


if __name__ == '__main__':
    n = int(input().strip())

    a = list(map(int, input().rstrip().split()))

    countSwaps(a)
