def solution(numbers, n):
    sum = 0
    
    for i in numbers:
        if sum > n:
            return sum
        sum += i
    return sum