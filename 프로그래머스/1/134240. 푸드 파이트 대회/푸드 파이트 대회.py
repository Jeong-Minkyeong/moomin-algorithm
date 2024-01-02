def solution(food):
    water = '0'
    foods = []
    for i, v in enumerate(food):
        if i == 0:
            continue
        foods.append(v//2)
        
    answer = [ str(i+1) for i, v in enumerate(foods) for j in range(v)]
    
    result = ''.join(answer) + water + ''.join(reversed(answer))
    return result