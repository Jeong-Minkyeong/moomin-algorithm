def solution(array, n):
    
    answer = list(filter(lambda x: x == n, array))
    return len(answer)