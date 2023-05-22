#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the countTriplets function below.


def countTriplets(arr, r):
    n = len(arr)
    j = n - 1
    cnt = 0
    if r == 1:
        dict = {}
        for v in arr:
            dict[v] = dict.get(v, 0) + 1
        for s in dict.values():
            if s > 2:
                cnt += s * (s - 1) * (s - 2) // 6
        return cnt

    cnts, dp = {}, {}
    while j > -1:
        k = arr[j]
        nextK = k * r
        items = dp.get(k, [])
        items.append(cnts.get(nextK, 0))
        dp[k] = items
        cnt += sum(dp.get(nextK, []))
        cnts[k] = cnts.get(k, 0) + 1
        j -= 1
    return cnt


print(countTriplets([1, 2, 2, 4], 2))
print(countTriplets([1, 3, 9, 9, 27, 81], 3))
print(countTriplets([1, 5, 5, 25, 125], 5))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     nr = input().rstrip().split()

#     n = int(nr[0])

#     r = int(nr[1])

#     arr = list(map(int, input().rstrip().split()))

#     ans = countTriplets(arr, r)

#     fptr.write(str(ans) + '\n')

#     fptr.close()
