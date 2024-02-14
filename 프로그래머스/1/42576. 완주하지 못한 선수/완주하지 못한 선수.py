def solution(participant, completion):
    answer = {}
    for i in participant:
        answer[i] = answer.get(i, 0) + 1
    
    for i in completion:
        answer[i] -= 1
        
    for i, v in answer.items():
        if v == 1:
            return i
        
        
        