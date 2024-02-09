def solution(n, lost, reserve):
    answer = 0
    intersection = list(set(lost) & set(reserve))
    for i in intersection:
        lost.remove(i)
        reserve.remove(i)
        
    lost = sorted(lost)
    reserve = sorted(reserve)
    
    for i in reserve:
        if (i-1) in lost:
            lost.remove(i-1)
        elif (i+1) in lost:
            lost.remove(i+1)
    
    answer = n - len(lost)
    return answer
    
    