def func(s):
    temp = []
    
    dic = {')' : '(', ']':'[', '}':'{'}
    
    for i in range(len(s)):
        if s[i] in ['(', '[', '{']:
            temp.append(s[i])
            continue
        
        if len(temp) == 0 or temp[-1] != dic[s[i]]:
            return 0
        
        temp.pop()
        
    return 1 if len(temp) == 0 else 0
        
        
def solution(s):
    answer = 0
    
    for i in range(len(s)):
        answer += func(s)
        s = s[1:] + s[0]
        
    return answer