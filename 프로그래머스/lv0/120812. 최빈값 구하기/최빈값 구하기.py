def solution(array):
    answer = [ array.count(i) for i in list(set(array))]
    
    if len(answer) == 1:
        return array[0]
    
    elif answer.count(max(answer)) > 1:
            
        return -1
        
    elif answer.count(max(answer)) == 1:
        
        array = list(set(array))
        return array[answer.index(max(answer))]
    
