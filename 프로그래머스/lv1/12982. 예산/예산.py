def solution(d, budget):
    d = sorted(d)
    count = 0
    answer = 0
    
    for i in d:
        answer += i
        if answer > budget:
            break
            
        count += 1
    return count