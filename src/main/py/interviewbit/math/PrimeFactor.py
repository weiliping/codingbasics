from typing import List
import math
import os

def prime_factor(num: int) -> List:
    arr = []
    if num < 4:
        arr.append(num)
        return arr
    for i in range(2, int(math.sqrt(num)) + 1):
        while num > 1 and num % i == 0:
            num //= i
            arr.append(i)
        if num == 1:
            return arr
    arr.append(num)
    return arr

def prime_num(num: int) -> int:
    res = 1
    if num < 4:
        return num
    for i in range(2, int(math.sqrt(num)) + 1):
        j = 0
        while num > 1 and num % i == 0:
            num //= i
            j ^= 1
        if j == 1:
            res *= i
        if num == 1:
            return res
    return res * num

if __name__ == "__main__":
    with open(os.path.dirname(os.path.abspath(__file__)) + '/result.txt', "a") as myfile:
        for i in range(1, 10001):
            res = prime_num(i)
            a = str(i) + "=" + str(res) + "\n"
            myfile.write(a)
            