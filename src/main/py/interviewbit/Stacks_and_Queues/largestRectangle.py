#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'largestRectangle' function below.
#
# The function is expected to return a LONG_INTEGER.
# The function accepts INTEGER_ARRAY h as parameter.
#


def largestRectangle(h):
    # Write your code here
    st = []
    s = 0
    for i in range(len(h)):
        if len(st) == 0:
            st.append([h[i], i])
        preInd = i
        while len(st) > 0 and st[-1][0] > h[i]:
            t = st.pop()
            preInd = t[1]
            s = max(s, t[0] * (i - t[1]))
        st.append([h[i], preInd])

    if len(st) > 0:
        m = st[-1][1] + 1
        while len(st) > 0:
            t = st.pop()
            s = max(s, t[0] * (m - t[1]))

    return s


print(largestRectangle([1, 2, 3, 4, 5]))

# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input().strip())

#     h = list(map(int, input().rstrip().split()))

#     result = largestRectangle(h)

#     fptr.write(str(result) + '\n')

#     fptr.close()
