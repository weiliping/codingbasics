#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'isBalanced' function below.
#
# The function is expected to return a STRING.
# The function accepts STRING s as parameter.
#


def isBalanced(s):
    # Write your code here
    dp = []
    for a in s:
        if a == '{' or a == '[' or a == '(':
            dp.append(a)
            continue
        if len(dp) != 0:
            if a == ')' and dp[-1] == '(':
                dp.pop(-1)
                continue
            if a == ']' and dp[-1] == '[':
                dp.pop(-1)
                continue
            if a == '}' and dp[-1] == '{':
                dp.pop(-1)
                continue
        return 'NO'
    return 'YES' if len(dp) == 0 else 'NO'


# s = '){[]()})}}]{}[}}})}{]{](]](()][{))])(}]}))(}[}{{)}{[[}[]'
# print(isBalanced(s))
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t = int(input().strip())

    for t_itr in range(t):
        s = input()

        result = isBalanced(s)

        fptr.write(result + '\n')

    fptr.close()
