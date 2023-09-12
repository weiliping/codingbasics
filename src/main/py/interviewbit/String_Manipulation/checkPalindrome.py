def solution(inputString):
    n = len(inputString)
    if n == 1:
        return True
    i = 0
    h = n // 2
    if n % 2 != 0:
        h += 1
    while i <= h:
        if inputString[i] != inputString[n - i - 1]:
            return False
        i += 1
    return True


def solution1(inputString):
    n = len(inputString)
    i, j = 0, n - 1
    while i < j:
        if inputString[i] != inputString[j]:
            return False
        i += 1
        j -= 1
    return True


print(solution1("hlbeeykoqqqqokyeeblh"))
