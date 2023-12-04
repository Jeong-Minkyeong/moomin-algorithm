def solution(s):
    answer = []
    temp = []
    for i, v in enumerate(s):
        if i == 0:
            answer.append(-1)
            continue
            
        for j in range(i):
            if v == s[j]:
                temp.append(i-j)
                
        if len(temp) == 0:
            answer.append(-1)
        else:
            answer.append(min(temp))
        temp.clear()
    return answer
