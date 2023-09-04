import math
import os
import random
import re
import sys


def onesAndTwos(a, b):
    MOD = 10**9 + 7
    L = 31
    dp_sum = [[-1 for _ in range(L)] for _ in range(L)]
    dp_bit = [[-1 for _ in range(L)] for _ in range(L)]

    def add(x, v):
        v %= MOD
        x += v
        if x >= MOD:
            x -= MOD
        return x

    def f_bit(lv, b, dp_sum, dp_bit):
        if lv > b:
            return 0
        if dp_bit[lv][b] != -1:
            return dp_bit[lv][b]
        dp_bit[lv][b] = f_sum(lv + 1, b - lv, dp_sum, dp_bit)
        return dp_bit[lv][b]

    def f_sum(lv, b, dp_sum, dp_bit):
        if lv > b:
            return 1
        if dp_sum[lv][b] != -1:
            return dp_sum[lv][b]
        tmp = f_sum(lv + 1, b, dp_sum, dp_bit)
        tmp = add(tmp, f_bit(lv, b, dp_sum, dp_bit))
        dp_sum[lv][b] = tmp
        return dp_sum[lv][b]
    if a == 0:
        ans = f_sum(1, b, dp_sum, dp_bit)
        # print(dp_sum)
        # print(dp_bit)
        return (ans + MOD - 1) % MOD
    ans = 0
    k = 1
    while (1 << k) <= a:
        k += 1
    k += 1
    ans = add(ans, (a + 1) * f_sum(k, b, dp_sum, dp_bit))
    ha = (1 << k) - a - 1
    nw, i = 0, 1
    last = 0
    while ha > 0:
        nw += 1
        if b < nw:
            break
        v = min((1 << i) - last, ha) * f_sum(k, b - nw, dp_sum, dp_bit)
        ans = add(ans, v)
        ha -= (1 << i) - last
        last = (1 << i)
        i += 1
        if i == k:
            last = 0
            i = 1
    # print(dp_sum)
    # print(dp_bit)
    return (ans + MOD - 1) % MOD


def onesAndTwosI(n):
    dp = [0 for _ in range(n + 1)]
    dp[1] = 1
    a = [[2]]
    s = set()
    s.add(2)
    for i in range(2, n + 1):
        b = []
        sub = set()
        for t in a:
            v1 = t.copy()
            v1.append(2)
            b.append(v1)
            v2 = t.copy()
            v2[-1] = v2[-1] * 2
            b.append(v2)
        for t in b:
            v = sum(t)
            if v not in s:
                sub.add(v)
            s.add(v)
        dp[i] = len(s)
        print(sorted(sub))
        # print(i, len(sub), sep=" = ")
        a = b
    return dp


def ones(n):
    l = sum(range(1, n)) + 1
    dp = [0 for _ in range(l)]
    s = [0]
    for i in range(1, n):
        s1 = s.copy()
        for a in s:
            v = a + i
            dp[v] += 1
            s1.append(v)
        s = s1
    # print(s)
    print(len(s))
    return dp


def onesAndTwosI(a, b):
    MOD = 10**9 + 7
    MXB = 1000
    M = 33
    p = [[0 for _ in range(MXB + 1)] for _ in range(M)]
    up = [False for _ in range(M)]

    def add(x, v):
        return (x + v) % MOD

    def pre(s):
        if up[s]:
            return
        up[s] = True
        p[s][0] = 1
        print(p[s])
        for _ in range(s, MXB + 1):
            for j in range(MXB, 0, -1):
                p[s][j] = add(p[s][j], p[s][j - 1])
        print("second = ", p[s])
        for j in range(1, MXB + 1):
            p[s][j] = add(p[s][j], p[s][j - 1])
        print("last = ", p[s])
        print(p[1][20])
    if a == 0:
        pre(1)
        return (p[1][b] + MOD - 1) % MOD

    t, s = 2, 1
    while t <= a:
        t *= 2
        s += 1
    t *= 2
    s += 1
    pre(s)

    ans = 0
    last, last2 = 0, t/2 + a + 1
    u = 0
    while u < s and u <= b:
        v = (1 << u) + a + (1 if u > 0 else 0)
        nxt = min(t, v)
        nxt2 = min(t, v + t/2)
        ans = add(ans, (nxt - last) * p[s][b - u])
        if u + s - 1 <= b:
            ans = add(ans, (nxt2 - last2) * p[s][b - (u + s - 1)])
        last = nxt
        last2 = nxt2
        u += 1
    return (ans + MOD - 1) % MOD


def onesAndTwosJava(a, b):
    MOD = 10**9 + 7
    L = 1001
    dp = [[0 for _ in range(L)] for _ in range(L)]
    dp1 = [[0 for _ in range(L)] for _ in range(L)]
    dp_sum = [[0 for _ in range(L)] for _ in range(L)]
    dp[1][1] = 1
    pow2 = [1 << i for i in range(32)]
    for i in range(2, L):
        for j in range(1, i + 1):
            tmp = 0
            for k in range(j + 1, i):
                tmp += dp[i - j][k]
                if tmp > MOD:
                    tmp -= MOD
            if i == j:
                tmp += 1
                if tmp > MOD:
                    tmp -= MOD
    for i in range(L):
        for j in range(1, L):
            dp_sum[i][j] = dp_sum[i][j - 1] + dp[i][j]
            if dp_sum[i][j] > MOD:
                dp_sum[i][j] -= MOD
    for k in range(1, L):
        for i in range(k, L):
            if i == k:
                dp1[k][i] = 1
                continue
            dp1[i][k] = dp1[i - 1][k] + dp[i][k]
            if dp1[i][k] > MOD:
                dp1[i][j] -= MOD
    arr_list = [[[0 for _ in range(32)] for _ in range(32)] for _ in range(L)]
    ar = [0 for _ in range(L)]
    for i in range(L):
        for j in range(1, min(int(i/2), 500) + 1):
            for k in range(j + 1, i - j + 1):
                rv = 0
                if j + k == i:
                    rv += 1
                    rv += dp_sum[i-j-k][i-j-k] - dp_sum[i-j-k][k]
                    if rv < 0:
                        rv += MOD

                    if rv >= MOD:
                        rv -= MOD
                    if k < 32:
                        arr_list[i][j][k] = rv
                    else:
                        ar[i] += rv
        ar[i] %= MOD
    if b == 0:
        return a
    if a == 0:
        return sum(dp1[b]) % MOD
    ans = 0
    for d in range(b):
        ans += dp1[b - 1][d] << 1
    ans %= MOD
    for d in range(32):
        for e in range(d + 1, 32):
            rv = arr_list[b][d][e]
            t = rv * min(a + 1, pow2[e] - pow2[d])
            ans += t
            ans %= MOD
    return ans


if __name__ == '__main__':
    # print(onesAndTwos(25))
    # dp = ones(25)
    # print(dp)
    # print(onesAndTwos(0, 20))
    print(onesAndTwosJava(0, 20))
