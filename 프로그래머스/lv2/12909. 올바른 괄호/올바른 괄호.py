def solution(s):
    
    answer = []

    for i in s:
        if i == '(':
            answer.append(i)

        else:
            if not answer:
                return False
            
            else:
                answer.pop()
                
    return True if not answer else False    