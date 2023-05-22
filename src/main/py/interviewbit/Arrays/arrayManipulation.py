import math
import os
import random
import re
import sys
import heapq
#
# Complete the 'arrayManipulation' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts following parameters:
#  1. INTEGER n
#  2. 2D_INTEGER_ARRAY queries
#


def arrayManipulationII(n, queries):
    queries.sort(key=lambda a: (a[0], a[1]))
    prevInd, prevVal, maxV = queries[0][0], queries[0][2], -1
    stack = [[queries[0][1], queries[0][2]]]
    i, m = 1, len(queries)

    while i < m:
        currItem = queries[i]
        if currItem[0] != prevInd:
            maxV = max(maxV, prevVal)
            while stack and stack[0][0] < currItem[0]:
                prevVal -= stack.pop(0)[1]
            prevInd = currItem[0]
            heapq.heappush(stack, [currItem[1], currItem[2]])
            i += 1
        else:
            while i < m and queries[i][0] == prevInd:
                prevVal += queries[i][2]
                heapq.heappush(stack, [queries[i][1], queries[i][2]])
                i += 1
    return max(maxV, prevVal)


def arrayManipulationI(n, queries):
    nums = []
    for q in queries:
        if q[0] not in nums:
            nums.append(q[0])
        if q[1] + 1 not in nums:
            nums.append(q[1] + 1)
    nums.sort()
    sums = [0 for i in range(len(nums)+1)]

    for q in queries:
        iS = bsFirstLess(nums, q[0])
        iE = bsFirstGreat(nums, q[1])
        for i in range(iS + 1, iE, 1):
            sums[i] += q[2]
    return max(sums)


def bsFirstLess(nums, v):
    n = len(nums)
    l, r = 0, n - 1
    while l <= r:
        mid = l + ((r - l) >> 1)
        if nums[mid] >= v:
            if mid == 0 or nums[mid - 1] < v:
                return mid - 1
            else:
                r = mid - 1
        else:
            if mid == n or nums[mid + 1] >= v:
                return mid
            else:
                l = mid + 1
    return -1


def bsFirstGreat(nums, v):
    n = len(nums)
    l, r = 0, n - 1
    while l <= r:
        mid = l + ((r - l) >> 1)
        if nums[mid] > v:
            if mid == 0 or nums[mid - 1] <= v:
                return mid
            else:
                r = mid - 1
        else:
            if mid == n:
                return mid
            elif nums[mid + 1] > v:
                return mid + 1
            else:
                l = mid + 1
    return -1


def arrayManipulation(n, queries):
    # Write your code here
    queries.sort(key=lambda a: (a[0], -a[1]))
    n, stack = len(queries), []
    maxV = queries[0][2]
    stack.append(queries[0])
    for i in range(1, len(queries), 1):
        curr = queries[i]
        j, stack2 = i + 1, []

        stack2.append(curr)
        while j < n and queries[j][0] == curr[0]:
            prev = stack2.pop(-1)
            next = queries[j]
            if prev[1] > next[1]:
                stack2.append([next[1] + 1, prev[1], prev[2]])
            stack2.append(next[0], next[1], next[2] + prev[2])
            j += 1

        while len(stack2) > 0:
            prevItem = stack.pop(-1)
            currItem = stack2.pop(0)
            if prevItem[1] < currItem[0]:
                stack.append(prevItem)
                stack.append(currItem)
                maxV = max(maxV, currItem[2])
                continue

            stack.append([prevItem[0], currItem[0] - 1, prevItem[2]])
            v = prevItem[2] + currItem[2]
            maxV = max(maxV, v)
            if prevItem[1] > currItem[1]:
                stack.append([currItem[0], currItem[1], v])
                stack.append([currItem[1] + 1, prevItem[1], prevItem[2]])
                continue
            stack.append([currItem[0], prevItem[1], v])
            if currItem[1] > prevItem[1]:
                stack.append([prevItem[1] + 1, currItem[1], prevItem[2]])
    return maxV


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    m = int(first_multiple_input[1])

    queries = []

    for _ in range(m):
        queries.append(list(map(int, input().rstrip().split())))

    result = arrayManipulation(n, queries)

    fptr.write(str(result) + '\n')

    fptr.close()
