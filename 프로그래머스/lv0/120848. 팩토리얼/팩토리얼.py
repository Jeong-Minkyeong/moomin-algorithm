def solution(n):
    answer = 1
    count = 0
    num = 1
    while(1):
        
        answer *= num
        num += 1
        
        if answer > n:
            break
            
        count += 1
        
    return count