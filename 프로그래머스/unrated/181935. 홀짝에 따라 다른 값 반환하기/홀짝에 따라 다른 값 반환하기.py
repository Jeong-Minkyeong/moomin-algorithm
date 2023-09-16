def solution(n):
    
    if n % 2 == 0:
        answer = [i**2 for i in range(n+1) if i % 2 ==0]
    else:
        answer = [i for i in range(n+1) if i % 2 != 0]
        
    return sum(answer)