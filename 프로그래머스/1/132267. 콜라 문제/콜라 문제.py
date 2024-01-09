def solution(a, b, n):  
    coke_count = 0
    empty_coke = n
    
    while(empty_coke >= a):
        count, temp = divmod(empty_coke, a)
        coke_count += (count*b)
        empty_coke = (count*b + temp)
        
    return coke_count