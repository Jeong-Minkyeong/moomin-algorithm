def solution(want, number, discount):
    answer = 0
    size = len(discount) - 10 + 1
    discount *= 2
    wants = dict(zip(want, number))
    
    for i in range(size):
        days = discount[i:i+10]
        for j in wants.keys():
            if days.count(j) != wants[j]:
                break
        else:
            answer += 1
    return answer