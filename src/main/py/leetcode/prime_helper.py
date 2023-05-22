
from itertools import accumulate
from typing import List


class PrimeHelper:
    __slots__ = "_minPrime"  # 每个数的最小质因数

    def __init__(self, maxN: int):
        """预处理 O(nloglogn)"""
        minPrime = list(range(maxN + 1))
        upper = int(maxN**0.5) + 1
        for i in range(2, upper):
            if minPrime[i] < i:
                continue
            for j in range(i * i, maxN + 1, i):
                if minPrime[j] == j:
                    minPrime[j] = i
        self._minPrime = minPrime

    def isPrime(self, n: int) -> bool:
        if n < 2:
            return False
        return self._minPrime[n] == n

    def getPrimeFactors(self, n: int):
        """求n的质因数分解 O(logn)"""
        pre, f = 1, self._minPrime
        while n > 1:
            m = f[n]
            if m != pre:
                yield m
                pre = m
            n //= m

    def getPrimes(self) -> List[int]:
        return [x for i, x in enumerate(self._minPrime) if i >= 2 and i == x]


ph = PrimeHelper(1000000)


class Solution:
    def findValidSplit(self, A: List[int]) -> int:
        R, book = dict(), [0] * len(A)

        for i, x in enumerate(A):
            for p in ph.getPrimeFactors(x):
                if p not in R:
                    R[p] = i
                book[R[p]] += 1
                book[i] -= 1
                R[p] = i

        res = next(i for i, acc in enumerate(accumulate(book)) if acc == 0)

        return res if res < len(A) - 1 else -1


# s = Solution()
# s.findValidSplit([4, 7, 8, 15, 3, 5])
ph2 = PrimeHelper(100)
for p in ph2.getPrimeFactors(15):
    print(p)
