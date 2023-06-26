#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'poisonousPlants' function below.
#
# The function is expected to return an INTEGER.
# The function accepts INTEGER_ARRAY p as parameter.
#


def poisonousPlants(p):
    # Write your code here
    res, n = 0, len(p)
    st = []
    for i in range(n - 1, -1, -1):
        if st and st[-1][0] > p[i]:
            sCnt = 0
            while st and st[-1][0] > p[i]:
                pre = st.pop(-1)
                sCnt = max(sCnt, pre[1])
                sCnt += 1
            if st:
                c = st[-1]
                st[-1] = [c[0], max(sCnt, c[1])]
            res = max(res, sCnt)
        st.append([p[i], 0])
    return res


# f = open(os.path.dirname(os.path.abspath(__file__)) + '/input_params.txt', 'r')
# dp = []
# for a in f.readline().split(" "):
#     dp.append(int(a.strip()))
# print(poisonousPlants(dp))

if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    n = int(input().strip())

    p = list(map(int, input().rstrip().split()))

    result = poisonousPlants(p)

    fptr.write(str(result) + '\n')

    fptr.close()
