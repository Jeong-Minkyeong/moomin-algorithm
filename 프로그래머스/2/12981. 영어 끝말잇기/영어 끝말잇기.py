def solution(n, words):
    answer = [0,0]
    dic = {}
    
    for i,v in enumerate(words):
        if i > 0 and v[0] != words[i-1][-1]:
            answer[0] = (i % n) +1
            answer[1] = (i // n) +1
            return answer
            
        dic[v] = dic.get(v, 0) + 1
        
        if dic[v] > 1:
            answer[0] = (i % n) +1
            answer[1] = (i // n) +1
            return answer
            
    return answer
