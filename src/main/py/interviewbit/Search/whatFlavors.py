#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'whatFlavors' function below.
#
# The function accepts following parameters:
#  1. INTEGER_ARRAY cost
#  2. INTEGER money
#


def whatFlavors(cost, money):
    # Write your code here
    dp = {}
    for i in range(len(cost)):
        if cost[i] not in dp.keys():
            dp[money - cost[i]] = i + 1
            continue
        return [dp.get(cost[i]), i + 1]
    return []


if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        money = int(input().strip())

        n = int(input().strip())

        cost = list(map(int, input().rstrip().split()))

        whatFlavors(cost, money)
