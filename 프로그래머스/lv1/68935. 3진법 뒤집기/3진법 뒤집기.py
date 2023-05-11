def solution(n):
    
    answer = []
    result = []
    
    while(n>0):
        n , i = divmod(n, 3)
        answer.append(i)
        
    for i,v in enumerate(answer):
        result.append(v*(3**(len(answer)-i-1)))
    
    return sum(result)

