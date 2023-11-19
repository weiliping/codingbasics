import requests
import json
MAX_V = 10 ** 9 + 7


def sortedSum(a):
    # Write your code here
    from bisect import bisect, insort
    res = 0
    n = len(a)
    sub_arr = []
    pre_sum = 0
    for i in range(n):
        j = bisect(sub_arr, a[i])
        curr_sum = pre_sum
        curr_sum += (j + 1) * a[i]
        if curr_sum >= MAX_V:
            curr_sum %= MAX_V
        if j < len(sub_arr):
            curr_sum += sum(sub_arr[j:])
            if curr_sum >= MAX_V:
                curr_sum %= MAX_V
        insort(sub_arr, a[i])
        pre_sum = curr_sum
        res += curr_sum
        if res >= MAX_V:
            res %= MAX_V
    return res


def sortedSumI(a):

    n = len(a)
    b = [i for i in range(1, n+1)]
    ar = [0]*(n)
    ans = 0
    MOD = 10**9 + 7

    for i in range(len(a)):
        for j in range(n-i):
            ar[j+i] += a[i]*b[j]

    for i in range(n):
        ans += ar[i]

    ans = ans % MOD
    return ans


def sortedSumII(a):
    ans = 0
    while a:
        def temp(l):
            l.sort()
            ansi = 0
            for j in range(0, len(l)):
                ansi = ansi+(j+1)*l[j]
            return ansi
        ans = ans+temp(a.copy())
        a.pop()
    return ans % ((10**9)+7)


a = [9, 5, 8]
# print(sortedSumII(a))

year = 2014
team = "Chelsea"
t = 0
for i in range(1, 11):
    api_url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + \
        str(year) + "&team1goals="+str(i) + "&team2goals="+str(i) + "&page=1"
    response = requests.get(api_url)
    json_object = json.loads(response.text)
    t += len(json_object["data"])
    pNum = json_object["total_pages"]
    p = 2
    while pNum >= p:
        api_url = "https://jsonmock.hackerrank.com/api/football_matches?year=" + \
            str(year) + "&team1goals=" + str(i) + \
            "&team2goals="+str(i) + "&page=" + str(p)
        response = requests.get(api_url)
        json_object = json.loads(response.text)
        t += len(json_object["data"])
        p += 1
print(t)
