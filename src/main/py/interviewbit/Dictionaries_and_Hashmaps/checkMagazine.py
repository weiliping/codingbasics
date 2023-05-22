#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'checkMagazine' function below.
#
# The function accepts following parameters:
#  1. STRING_ARRAY magazine
#  2. STRING_ARRAY note
#


def checkMagazine(magazine, note):
    # Write your code here
    dict = {}
    for w in magazine:
        dict[w] = dict.get(w, 0) + 1

    for w in note:
        v = dict.get(w, 0)
        if v <= 0:
            print("No")
            return
        dict[w] = v - 1

    print("Yes")


if __name__ == '__main__':
    first_multiple_input = input().rstrip().split()

    m = int(first_multiple_input[0])

    n = int(first_multiple_input[1])

    magazine = input().rstrip().split()

    note = input().rstrip().split()

    checkMagazine(magazine, note)
