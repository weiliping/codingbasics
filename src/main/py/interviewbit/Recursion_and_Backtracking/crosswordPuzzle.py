#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'crosswordPuzzle' function below.
#
# The function is expected to return a STRING_ARRAY.
# The function accepts following parameters:
#  1. STRING_ARRAY crossword
#  2. STRING words
#


def isCompleted(crossword, visited):
    for i in range(10):
        for j in range(10):
            if crossword[i][j] == '_':
                return False
    for a in visited:
        if not a:
            return False
    return True


def helper(crossword, words, visited):
    if isCompleted(crossword, visited):
        return True
    for i in range(10):
        for j in range(10):
            if crossword[i][j] == '-':
                cnt = 0
                l, r = j, j
                while l > 0 and crossword[i][l - 1] != '+':
                    l -= 1
                while r < 9 and crossword[i][r + 1] != '+':
                    r += 1
                if l != j or r != j:
                    cnt = r - l + 1
                if cnt != 0:
                    prev = []
                    for k in range(l, r + 1, 1):
                        prev.append(crossword[i][k])
                    for inde in range(len(words)):
                        if visited[inde] or len(words[inde]) != cnt:
                            continue
                        v = True
                        for k in range(cnt):
                            if prev[k] != '-' and prev[k] != words[inde][k]:
                                v = False
                        if not v:
                            continue
                        visited[inde] = True
                        for k in range(cnt):
                            crossword[i][l + k] = words[inde][k]
                        if helper(crossword, words, visited):
                            return True
                        visited[inde] = False
                        for k in range(cnt):
                            crossword[i][l + k] = prev[k]
                    return False
                u, d = i, i
                cnt = 0
                while u > 0 and crossword[u - 1][j] != '+':
                    u -= 1
                while d < 9 and crossword[d + 1][j] != '+':
                    d += 1
                if d != i or u != i:
                    cnt = d - u + 1
                if cnt != 0:
                    prev = []
                    for k in range(u, d + 1, 1):
                        prev.append(crossword[k][j])
                    for inde in range(len(words)):
                        if visited[inde] or len(words[inde]) != cnt:
                            continue
                        v = True
                        for k in range(cnt):
                            if prev[k] != '-' and prev[k] != words[inde][k]:
                                v = False
                        if not v:
                            continue
                        visited[inde] = True
                        for k in range(cnt):
                            crossword[u + k][j] = words[inde][k]
                        if helper(crossword, words, visited):
                            return True
                        visited[inde] = False
                        for k in range(cnt):
                            crossword[u+k][j] = prev[k]
                    return False


def crosswordPuzzle(crossword, words):
    crossArray = []
    for cr in crossword:
        d = []
        for a in cr:
            d.append(a)
        crossArray.append(d)
    strings = words.split(";")

    visited = [False] * len(strings)
    res = []
    if helper(crossArray, strings, visited):
        for c in crossArray:
            res.append(''.join([str(elem) for elem in c]))
        return res
    return crossword


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    crossword = []

    for _ in range(10):
        crossword_item = input()
        crossword.append(crossword_item)

    words = input()

    result = crosswordPuzzle(crossword, words)

    fptr.write('\n'.join(result))
    fptr.write('\n')

    fptr.close()
