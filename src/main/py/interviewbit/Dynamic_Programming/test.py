def solve_partition_count(B):
    dp = [[0] * (B + 1) for _ in range(B + 1)]
    dp[0][0] = 1

    for i in range(1, B + 1):
        for j in range(1, i + 1):
            dp[i][j] = dp[i][j - 1] + dp[i - j][j - 1]

    total_ways = sum(dp[B][j] for j in range(1, B + 1))
    print(dp)
    return total_ways


# Example usage
B = 5
result = solve_partition_count(B)
print("Number of ways:", result)
