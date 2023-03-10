def solution(dot):
    result = 0
    answer = (dot[0]*dot[1])
    if answer > 0 and dot[0] > 0:
        result = 1
        return result
    
    elif answer > 0 and dot[0] < 0:
        result = 3
        return result
    
    elif answer < 0 and dot[0] > 0:
        result = 4
        return result
    
    elif answer < 0 and dot[0] < 0:
        result = 2
        return result
