def solution(a, d, included):
    arithmetic = {}
    answer = []
    for i,v in enumerate(included):
        arithmetic[i] = (d*i)+a
    for i,v in enumerate(included):
        if v == True:
            answer.append(arithmetic[i])
    return sum(answer)