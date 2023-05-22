#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'hourglassSum' function below.
#
# The function is expected to return an INTEGER.
# The function accepts 2D_INTEGER_ARRAY arr as parameter.
#


def hourglassSum(arr):
    # Write your code here
    maxSum = -100000
    inds = [-1, 0, 1]
    for i in range(1, 5, 1):
        for j in range(1, 5, 1):
            curSum = arr[i][j]
            for ind in inds:
                curSum += arr[i + 1][j + ind] + arr[i - 1][j + ind]
            maxSum = max(maxSum, curSum)
    return maxSum


if __name__ == '__main__':
