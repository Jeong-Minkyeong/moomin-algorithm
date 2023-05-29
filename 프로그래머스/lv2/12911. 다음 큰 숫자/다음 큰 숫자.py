def solution(n):
    
    counts = 0
    answer = str(bin(n)[2:])
    counts = answer.count('1')
    
    while(1):
        n += 1
        num = str(bin(n)[2:])
        if counts == num.count('1'):
            return n
        
    return 0