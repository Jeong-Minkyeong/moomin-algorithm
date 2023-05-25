def solution(n):
    available = []
    sqrt_n = int((n * 2) ** 0.5)
    for i in range(sqrt_n):
        if (2 * n / (i + 1)) % 1 == 0:
            available.append(i + 1)
            available.append(int(2 * n / (i + 1)))
    total = 0
    for i in available:
        if (n * 2) / i + 1 - i > 0 and ((n * 2) / i + 1 - i) % 2 == 0:
            total += 1
    return total
        