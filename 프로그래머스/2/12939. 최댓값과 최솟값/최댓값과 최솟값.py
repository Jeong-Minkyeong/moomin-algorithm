def solution(s):
    num = s.split()
    answer = [int(i) for i in num]
    
    return str(min(answer))+" "+str(max(answer))
    