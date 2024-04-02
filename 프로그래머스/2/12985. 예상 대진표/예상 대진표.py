def solution(n,a,b):
    answer = 0
    a, b = min(a, b), max(a, b)

    while(n > 1):
        answer += 1
        if a % 2 != 0 and abs(a-b) == 1:
            return answer
        
        n = n // 2
        if a % 2 == 0:
            a = a // 2
        else:
            a = a // 2 + 1 
        
        if b % 2 == 0:
            b = b // 2
        else:
            b = b // 2 + 1
    return answer

