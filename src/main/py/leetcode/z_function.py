from typing import List
def calc_z(word: str) -> List[int]:
    n = len(word)
    z = [0] * n
    l, r = 0, 0
    for i in range(1, n):
        if i <= r:
            z[i] = min(z[i - l], r - i + 1)
        while i + z[i] < n and word[z[i]] == word[i + z[i]]:
            l, r = i, i + z[i]
            z[i] += 1
    return z

print(calc_z("AABZAABZCAABZAABZA"))