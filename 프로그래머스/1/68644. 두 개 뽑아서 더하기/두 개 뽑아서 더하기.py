def solution(numbers):
    answer = []
    for i, v1 in enumerate(numbers):
        for j, v2 in enumerate(numbers):
            if i <= j:
                continue
            answer.append(v1+v2)
    
    return sorted(set(answer))