#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'travelAroundTheWorld' function below.
#
# The function is expected to return an INTEGER.
# The function accepts following parameters:
#  1. INTEGER_ARRAY a
#  2. INTEGER_ARRAY b
#  3. LONG_INTEGER c
#


def travelAroundTheWorld(a, b, c):
    # Write your code here
    print(a, b, c)


if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    first_multiple_input = input().rstrip().split()

    n = int(first_multiple_input[0])

    c = int(first_multiple_input[1])

    a = list(map(int, input().rstrip().split()))

    b = list(map(int, input().rstrip().split()))
