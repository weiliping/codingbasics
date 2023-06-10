import math
import os
import random
import re
import sys

# Complete the maxSubsetSum function below.


def maxSubsetSum(arr):
    n = len(arr)
    s_arr = [0] * (n + 2)
    m = 0
    for i in range(n):
        s_arr[i + 2] = max(s_arr[i + 1], s_arr[i] + arr[i])
        m = max(s_arr[i + 2], m)
    return m


print(maxSubsetSum([3, 7, 4, 6, 5]))
print(maxSubsetSum([2, 1, 5, 8, 4]))
print(maxSubsetSum([3, 5, -7, 8, 10]))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input())

#     arr = list(map(int, input().rstrip().split()))

#     res = maxSubsetSum(arr)

#     fptr.write(str(res) + '\n')

#     fptr.close()
