def solution(babbling):
    words = ["aya", "ye", "woo", "ma"]
    answer = 0
    for i in babbling: 
        for w in words:
            if w * 2 not in i:  
                i = i.replace(w, ' ')
        if i.isspace():
            answer += 1  
    return answer