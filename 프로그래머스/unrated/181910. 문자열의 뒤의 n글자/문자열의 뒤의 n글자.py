def solution(my_string, n):
    answer = list(my_string)
    return ''.join(answer[len(answer)-n:])
