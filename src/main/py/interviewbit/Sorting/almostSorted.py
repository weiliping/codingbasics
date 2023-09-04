#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'almostSorted' function below.
#
# The function accepts INTEGER_ARRAY arr as parameter.
#


def almostSorted(arr):
    def swapInds(j, k, ks):
        tt = ks[j]
        ks[j] = ks[k]
        ks[k] = tt
    n = len(arr)
    ks = [i for i in range(n)]
    ks.sort(key=lambda i: arr[i])
    i, j, k, startI, endI = 0, -1, -1, -1, -1
    canBeSorted, swaped, reversed = True, False, False
    while i < n:
        if i == ks[i]:
            i += 1
            continue
        t = ks[i]
        if ks[t] == i:
            if n == 2 or ks[i + 1] == i + 1 or abs(t - i) == 1:
                if swaped:
                    canBeSorted = False
                    break
                swaped = True
                j, k = i, t
                swapInds(j, k, ks)
                i += 1
                continue
            if reversed:
                canBeSorted = False
                break
            for ind in range(i, ks[i] + 1):
                if ks[ind] == t:
                    t -= 1
                else:
                    canBeSorted = False
                    break
            if canBeSorted:
                reversed = True
                startI, endI = i, ks[i]
            i = ks[i] + 1
            continue
        canBeSorted = False
        break

    if canBeSorted:
        print("yes")
        if swaped:
            print("swap", j + 1, k + 1)
        if reversed:
            print("reverse", startI + 1, endI + 1)
    else:
        print("no")


def almostSorted1(arr):
    # Write your code here
    def swapInds(j, k, ks):
        tt = ks[j]
        ks[j] = ks[k]
        ks[k] = tt
    n = len(arr)
    ks = [i for i in range(n)]
    ks.sort(key=lambda i: arr[i])
    swaped, reversed = False, False
    canBeSorted = True
    j, k = -1, -1
    startI, endI = -1, -1

    i = 0
    while i < n:
        if i == ks[i]:
            i += 1
            continue
        if swaped or reversed:
            canBeSorted = False
            break
        if ks[ks[i]] == i:
            t = ks[i]
            if t == i + 1:
                if swaped:
                    canBeSorted = False
                    break
                swaped = True
                j, k = i, t
                swapInds(j, k, ks)
                i = ks[i] + 1
                continue
            if ks[i + 1] == t - 1 or ks[t - 1] == i + 1:
                if reversed:
                    canBeSorted = False
                    break
                for ind in range(i, t + 1, 1):
                    if ks[ind] == t:
                        t -= 1
                    else:
                        canBeSorted = False
                        break
                if canBeSorted:
                    reversed = True
                    startI, endI = i, ks[i]
            else:
                if swaped:
                    canBeSorted = False
                    break
                swaped = True
                j, k = i, t
                swapInds(j, k, ks)
            i = ks[i] + 1
            continue
        i1 = ks[i]
        i2 = ks[i1]
        if ks[i2] == i:
            if swaped:
                canBeSorted = False
                break
            if ks[i + 1] == i1 - 1 or ks[i2 - 1] == i + 1:
                if ks[i + 1] == i1 - 1:
                    j, k = i1, i2
                else:
                    j, k = i, i1
                swaped = True
                swapInds(j, k, ks)

                if reversed:
                    canBeSorted = False
                    break
                t = ks[i]
                for ind in range(i, ks[i] + 1):
                    # print(ind, t)
                    if ks[ind] == t:
                        t -= 1
                    else:
                        canBeSorted = False
                        break
                if canBeSorted:
                    reversed = True
                    startI, endI = i, ks[i]
            else:
                j, k = i, i2
                swapInds(j, k, ks)
                swaped = True
        else:
            i3 = ks[i2]
            if ks[i3] == i:
                if swaped:
                    canBeSorted = False
                    break
                if ks[i + 1] == ks[i] - 1 or ks[i3 - 1] == i + 1:
                    swaped = True
                    if ks[i + 1] == ks[i] - 1:
                        j, k = i1, i3
                    else:
                        j, k = i, i2
                    swapInds(j, k, ks)
                    if reversed:
                        canBeSorted = False
                        break
                    t = ks[i]
                    for ind in range(i, ks[i] + 1):
                        if ks[ind] == t:
                            t -= 1
                        else:
                            canBeSorted = False
                            break
                    if canBeSorted:
                        reversed = True
                        startI, endI = i, ks[i]
            else:
                canBeSorted = False
                break
        i = ks[i] + 1
    if canBeSorted:
        print("yes")
        if swaped:
            print("swap", j + 1, k + 1)
        if reversed:
            print("reverse", startI + 1, endI + 1)
    else:
        print("no")


f = open(os.path.dirname(os.path.abspath(__file__)) +
         '/almostSorted_params.txt', 'r')
queries = []
for a in f:
    str = a.split(" ")
    for s in str:
        queries.append(int(s.strip()))
# almostSorted(queries)
# almostSorted([4104, 8529, 49984, 54956, 63034, 82534, 84473, 86411, 92941, 95929, 108831, 894947, 125082, 137123, 137276, 142534, 149840, 154703, 174744, 180537, 207563, 221088, 223069, 231982, 249517, 252211, 255192, 260283, 261543, 262406, 270616, 274600, 274709, 283838, 289532, 295589, 310856, 314991, 322201, 339198, 343271, 383392, 385869, 389367, 403468, 441925, 444543, 454300, 455366, 469896,
#  478627, 479055, 484516, 499114, 512738, 543943, 552836, 560153, 578730, 579688, 591631, 594436, 606033, 613146, 621500, 627475, 631582, 643754, 658309, 666435, 667186, 671190, 674741, 685292, 702340, 705383, 722375, 722776, 726812, 748441, 790023, 795574, 797416, 813164, 813248, 827778, 839998, 843708, 851728, 857147, 860454, 861956, 864994, 868755, 116375, 911042, 912634, 914500, 920825, 979477])
# almostSorted([3, 1, 2])
# almostSorted([4, 2])
almostSorted([1, 2, 3, 5, 4, 6])
# almostSorted([1, 5, 4, 3, 2, 6])
# if __name__ == '__main__':
#     n = int(input().strip())

#     arr = list(map(int, input().rstrip().split()))

#     almostSorted(arr)
