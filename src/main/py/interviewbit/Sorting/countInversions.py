#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'countInversions' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY arr as parameter.
#


def countInversions(arr):
    # Write your code here
    def mergeSort(arr, l, r, temp):
        inv_count = 0
        if l >= r:
            return inv_count
        mid = l + ((r - l) >> 1)
        inv_count += mergeSort(arr, l, mid, temp)
        inv_count += mergeSort(arr, mid + 1, r, temp)
        inv_count += merge(arr, l, mid, r, temp)
        return inv_count

    def merge(arr, l, mid, r, temp):
        inv_count = 0
        l_start, l_end = l, mid
        r_start, r_end = mid + 1, r
        size = 0
        while l_start <= l_end and r_start <= r_end:
            if arr[l_start] > arr[r_start]:
                inv_count += l_end - l_start + 1
                temp[size] = arr[r_start]
                r_start += 1
            else:
                temp[size] = arr[l_start]
                l_start += 1
            size += 1
        while l_start <= l_end:
            temp[size] = arr[l_start]
            size += 1
            l_start += 1

        while r_start <= r_end:
            temp[size] = arr[r_start]
            size += 1
            r_start += 1

        for i in range(size):
            arr[l + i] = temp[i]
        return inv_count
    n = len(arr)
    return mergeSort(arr, 0, n - 1, [0] * n)


print(countInversions([2, 1, 3, 1, 2]))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        arr = list(map(int, input().rstrip().split()))

        result = countInversions(arr)

        fptr.write(str(result) + '\n')

    fptr.close()
