def precalculate_lookup_table(N):
    lookup_table = [0] * N
    lookup_table[0] = 1

    for i in range(1, N):
        lookup_table[i] = 2 * lookup_table[i-1]

    return lookup_table


def find_decibinary(lookup_table, decimal):
    left = 0
    right = len(lookup_table) - 1

    while left <= right:
        mid = (left + right) // 2
        if lookup_table[mid] <= decimal:
            left = mid + 1
        else:
            right = mid - 1

    return right


def solve_decibinary_numbers(queries):
    N = max(queries) + 1
    lookup_table = precalculate_lookup_table(N)

    cumulative_sum = [0] * N
    for i in range(1, N):
        cumulative_sum[i] = cumulative_sum[i-1] + lookup_table[i]

    results = []
    for query in queries:
        index = find_decibinary(cumulative_sum, query)
        target = query - cumulative_sum[index]

        left = 0
        right = lookup_table[index] - 1

        while left <= right:
            mid = (left + right) // 2
            decimal = calculate_decimal(mid)
            if decimal == target:
                results.append(mid)
                break
            elif decimal < target:
                left = mid + 1
            else:
                right = mid - 1

    return results

# Helper function to convert decibinary number to decimal


def calculate_decimal(decibinary):
    decimal = 0
    power = 0
    while decibinary > 0:
        decimal += (decibinary % 10) * (2 ** power)
        decibinary //= 10
        power += 1
    return decimal


# Example usage
queries = [1, 5, 10]
results = solve_decibinary_numbers(queries)
print("Results:", results)
