import os
import random
import re
import sys

# Complete the riddle function below.


def riddle(arr):
    # complete this function
    n = len(arr)
    res = [0] * n
    st = []
    st.append([arr[0], 0])
    for i in range(1, n):
        c, ind = 0, i
        while len(st) > 0 and st[-1][0] > arr[i]:
            v = st.pop()
            eInd = i - v[1]
            for j in range(c, eInd):
                res[j] = max(res[j], v[0])
            c = eInd
            ind = v[1]
        st.append([arr[i], ind])
    p = n
    while len(st) > 0:
        v = st.pop()
        while p > v[1]:
            res[n - p] = max(res[n - p], v[0])
            p -= 1
    return res


print(riddle([2, 6, 1, 12]))  # 12, 2, 1, 1
print(riddle([1, 2, 3, 5, 1, 13, 3]))  # 13, 3, 2, 1, 1, 1, 1
print(riddle([3, 5, 4, 7, 6, 2]))  # 7 6 4 4 3 2
print(riddle([789168277, 694294362, 532144299, 20472621, 316665904, 59654039, 685958445, 925819184, 371690486, 285650353, 522515445, 624800694, 396417773, 467681822, 964079876, 355847868, 424895284, 50621903, 728094833, 535436067, 221600465, 832169804, 641711594, 518285605, 235027997, 904664230,
              223080251, 337085579, 5125280, 448775176, 831453463, 550142629, 822686012, 555190916, 911857735, 144603739, 751265137, 274554418, 450666269, 984349810, 716998518, 949717950, 313190920, 600769443, 140712186, 218387168, 416515873, 194487510, 149671312, 241556542, 575727819, 873823206]))
# if __name__ == '__main__':
#     fptr = open(os.environ['OUTPUT_PATH'], 'w')

#     n = int(input())

#     arr = list(map(int, input().rstrip().split()))

#     res = riddle(arr)

#     fptr.write(' '.join(map(str, res)))
#     fptr.write('\n')

#     fptr.close()
