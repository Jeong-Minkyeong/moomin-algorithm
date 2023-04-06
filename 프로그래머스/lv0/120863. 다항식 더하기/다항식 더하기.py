def solution(polynomial):
    
    polynomial = polynomial.split(" + ")
    result = [0, 0]
    
    for i in polynomial:
        if 'x'in i:
            if i == 'x':
                result[0] += 1 
            else:
                result[0] += int(i.replace('x', ''))
        else:
            result[1] += int(i)
    
    if result[0] == 0:
        return str(result[1])
    
    elif result[0] == 1:
        
        if result[1] == 0:
            return 'x'
        
        else:
            return "x + " + str(result[1])
        
    elif result[0] != 1:
        
        if result[1] == 0:
            return str(result[0])+"x"
        
        else:
            return str(result[0]) + "x + " + str(result[1]) 
        
    