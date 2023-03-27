def solution(numbers, k):
    answer=0
    c = 0
    
    if len(numbers)%2 == 0:
        while(1):
            
            for i in range(0, len(numbers),2):
                c += 1
                if c == k:
                    return numbers[i]

    else:
        while(1):
            
            for i in range(0, len(numbers),2):
                c += 1
                if c == k:
                    return numbers[i]
                
            for i in range(1, len(numbers),2):
                c += 1
                if c == k:
                    return numbers[i]
            
        
    
