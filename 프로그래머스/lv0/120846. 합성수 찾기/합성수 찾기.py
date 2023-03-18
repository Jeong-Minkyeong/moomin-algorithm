def solution(n):
    answer = [num for num in range(1, n+1) for i in range(2, num) if num%i == 0 and num !=2 and num !=1 ]
    return len(list(set(answer)))