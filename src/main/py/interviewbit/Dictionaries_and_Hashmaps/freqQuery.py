#!/bin/python3

import math
import os
import random
import re
import sys

# Complete the freqQuery function below.


def freqQuery(queries):
    dict, res = {}, []
    for q in queries:
        if q[0] == 1:
            prevV = 0
            if q[1] in dict.keys():
                prevV = dict.get(q[1])
            dict[q[1]] = prevV + 1
        elif q[0] == 2:
            if q[1] in dict.keys():
                if dict.get(q[1]) > 1:
                    dict[q[1]] = dict.get(q[1]) - 1
                else:
                    dict.pop(q[1])
        elif q[0] == 3:
            res.append(1 if q[1] in dict.values() else 0)
    return res


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    q = int(input().strip())

    queries = []

    for _ in range(q):
        queries.append(list(map(int, input().rstrip().split())))

    ans = freqQuery(queries)

    fptr.write('\n'.join(map(str, ans)))
    fptr.write('\n')

    fptr.close()
