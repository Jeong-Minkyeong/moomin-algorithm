def solution(k, tangerine):
    tangerines = {}
    answer = 0
    for i in tangerine:
        tangerines[i] = tangerines.get(i, 0) + 1
    sorted_tangerines = sorted(tangerines.values(), reverse=True)
    
    while(k > 0):
        k -= sorted_tangerines.pop(0)
        answer += 1
    return answer