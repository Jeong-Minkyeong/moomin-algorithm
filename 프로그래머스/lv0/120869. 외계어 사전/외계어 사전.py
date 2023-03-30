def solution(spell, dic):
    answer = []
    for s in dic:
        for i in spell:
            if i not in s: 
                answer.append(s)
                break
    
    return 2 if len(answer) is len(dic) else 1
             
                
   