#!/bin/python3

import math
import os
import random
import re
import sys

f = open(os.path.dirname(os.path.abspath(__file__)) +
         '/invoice_number.txt', 'r')

report_numbers = set()
for a in f:
    a = a.strip()
    if len(a) < 8:
        b, i = a, len(a)
        while i < 8:
            b = '0' + b
            i += 1
        a = b
    report_numbers.add(a)
print(report_numbers)

f = open(os.path.dirname(os.path.abspath(__file__)) +
         '/invoice_number2.txt', 'r')
db_numbers = set()
for b in f:
    b = b.strip()
    # print(b)
    db_numbers.add(b)
# print(db_numbers)

left = set()
for f_a in report_numbers:
    if f_a not in db_numbers:
      left.add(f_a)
# print(len(left))
# print(left)
