def solution(clothes):
    answer = 1
    daily = []
    clothes_dict = {}
    
    for i in clothes:
        clothes_dict[i[1]] = clothes_dict.get(i[1], 1) + 1
    values = list(clothes_dict.values())
    
    for i in values:
        answer *= i
    return answer-1