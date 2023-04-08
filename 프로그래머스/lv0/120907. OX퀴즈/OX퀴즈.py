def solution(quiz):
    
    quiz_list = [ i.split() for i in quiz ]

    answer = []
    for v in quiz_list:
        result = int(v[-1])
        
        if v[1] == '-':
            if int(v[0]) - int(v[2]) == result:
                answer.append("O")
            else:
                answer.append("X")
        else:
            if int(v[0]) + int(v[2]) == result:
                answer.append("O")
            else:
                answer.append("X")
            
    return answer