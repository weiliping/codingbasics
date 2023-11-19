def minLength(s: str) -> int:
    q = []
    n = len(s)
    for i in range(n):
        if len(q) == 0 or (q[-1] != 'C' and q[-1] != 'A'):
            q.append(s[i])
            continue
        if q[-1] == 'C' and s[i] == 'D':
            q.pop(-1)
        elif q[-1] == 'A' and s[i] == 'B':
            q.pop(-1)
        else:
            q.append(s[i])
    return len(q)


print(minLength("ABFCACDB"))
