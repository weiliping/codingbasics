#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'activityNotifications' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY expenditure
#  2. INTEGER d
#


def getMiddle(cnts, v):
    i = 0
    while i < 201:
        if cnts[i] != 0:
            if cnts[i] < v:
                v -= cnts[i]
            else:
                return [i, v]
        i += 1


def getNext(cnts, curr):
    if cnts[curr[0]] > curr[1]:
        return [curr[0], curr[1] + 1]
    else:
        j = curr[0] + 1
        while j < 201 and cnts[j] == 0:
            j += 1
        return [j, 1]


def getPrev(cnts, curr):
    if cnts[curr[0]] > 1 and curr[1] > 1:
        return [curr[0], curr[1] - 1]
    else:
        j = curr[0] - 1
        while j >= 0 and cnts[j] == 0:
            j -= 1
        return [j, cnts[j]]


def getMidVal(midVals, isOdd):
    return (midVals[0][0] << 1) if isOdd else (midVals[0][0] + midVals[1][0])


def updateOddMiddel(cnts, midVals, newOne, oldOne):
    mid = midVals[0][0]
    if newOne < mid:
        if oldOne >= mid:
            midVals[0] = getPrev(cnts, midVals[0])
    elif newOne == mid:
        if oldOne < mid:
            midVals[0][1] += 1
    else:
        if oldOne <= mid:
            midVals[0] = getNext(cnts, midVals[0])


def updateEvenMiddel(cnts, midVals, newOne, oldOne):
    m1 = midVals[0][0]
    m2 = midVals[1][0]
    if newOne < m1:
        if oldOne == m1:
            if m1 == m2:
                midVals[1] = getPrev(cnts, midVals[1])
            midVals[0] = getPrev(cnts, midVals[0])
        elif oldOne >= m2:
            midVals[1] = getPrev(cnts, midVals[1])
            midVals[0] = getPrev(cnts, midVals[1])
    elif newOne == m1:
        if oldOne < m1:
            midVals[0] = getNext(cnts, midVals[0])
        elif oldOne >= m2:
            midVals[1] = getPrev(cnts, midVals[1])
            midVals[0] = getPrev(cnts, midVals[1])
    elif newOne == m2:
        if oldOne < m2:
            midVals[0] = getPrev(cnts, midVals[1])
    else:
        if oldOne < m2:
            midVals[0] = getNext(cnts, midVals[0])
            midVals[1] = getNext(cnts, midVals[1])
        elif oldOne == m2:
            if cnts[m2] == 0:
                midVals[1] = getNext(cnts, midVals[1])


def activityNotifications(expenditure, d):
    # Write your code here
    cnts = [0 for i in range(201)]

    for i in range(d):
        cnts[expenditure[i]] += 1

    isOdd = d & 1 == 1
    v = (d + 1) >> 1

    midVals = [getMiddle(cnts, v)]
    if not isOdd:
        midVals.append(getNext(cnts, midVals[0]))

    cnt = 0
    for j in range(d, len(expenditure), 1):
        oldOne = expenditure[j - d]
        newOne = expenditure[j]
        if getMidVal(midVals, isOdd) <= newOne:
            cnt += 1
        cnts[oldOne] -= 1
        cnts[newOne] += 1
        midVals = [getMiddle(cnts, v)]
        if not isOdd:
            midVals.append(getNext(cnts, midVals[0]))
    return cnt


# print(activityNotifications([2, 3, 4, 2, 3, 6, 8, 4, 5], 5))  # 2
# print(activityNotifications([10, 20, 30, 40, 50], 3))  # 2
# print(activityNotifications([1, 2, 3, 4, 4], 4))  # 1
file1 = open('/Users/paul/memo/926.log', 'r')
lines = file1.readlines()
nums = lines[0].split(" ")
dp = []
for num in nums:
    dp.append(int(num))
print(activityNotifications(dp, 40001))  # 926
# 633
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     first_multiple_input = input().rstrip().split()

#     n = int(first_multiple_input[0])

#     d = int(first_multiple_input[1])

#     expenditure = list(map(int, input().rstrip().split()))

#     result = activityNotifications(expenditure, d)

#     fptr.write(str(result) + '\n')

#     fptr.close()
