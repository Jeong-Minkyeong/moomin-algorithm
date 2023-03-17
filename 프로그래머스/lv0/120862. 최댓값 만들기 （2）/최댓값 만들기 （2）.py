def solution(numbers):
    answer = sorted(numbers)
    result = [answer[0]*answer[1] if answer[0]*answer[1] >= answer[-1]*answer[-2] else answer[-1]*answer[-2]]
    return result[0]