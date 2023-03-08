def solution(numbers):
    sum = 0
    for c in numbers:
        sum += c
    sum /=  len(numbers) 
    return sum