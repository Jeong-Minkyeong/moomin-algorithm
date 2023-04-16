def solution(numbers):
    answer = [i for i in range(1, 10) if i not in numbers]
    return sum(answer)