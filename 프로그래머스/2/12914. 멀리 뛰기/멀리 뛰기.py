def solution(n):
    #피보나치 수열 문제
    a,b = 1,2
    if n == 1:
        return 1
    
    elif n == 2:
        return 2
    
    for i in range(1,n):
        a,b = b, a+b
        
    return a%1234567


