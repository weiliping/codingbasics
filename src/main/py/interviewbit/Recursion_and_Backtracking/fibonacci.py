
dp = [-1 for i in range(31)]


def fibonacci(n):
    # Write your code here.
    if dp[n] != -1:
        return dp[n]
    if n < 2:
        dp[n] = n
        return dp[n]
    dp[n] = fibonacci(n - 1) + fibonacci(n - 2)
    return dp[n]


n = int(input())
print(fibonacci(n))
