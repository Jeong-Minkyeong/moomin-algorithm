def solution(num):
    
    count = 0
    while(count < 500):
        if num == 1:
            
            return count
        else:
            
            if num % 2 == 0:
                num = num // 2
            
            else:
                num = num*3+1
        
        count += 1
    return count if count < 500 else -1