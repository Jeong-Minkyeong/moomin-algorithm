def solution(s):
    s = list(s.lower())
    for i, v in enumerate(s):
        
        if i == 0:
            if v == ' ':
                pass
            else:
                if v.isalpha() == True:
                    s[i] = v.upper()

                else:
                    pass
                
        elif s[i-1] == ' ':
            if v == ' ' or v.isdigit() == True:
                pass
            
            elif v.isalpha() == True:
                s[i] = v.upper()
                
    return ''.join(s)
            
            
# s.split(' ') >> 이렇게 쪼개면 띄어쓰기까지 같이 담김
# ' '.join(s)  >> 요것도 마찬가지 공백도 같이 조인됨
                
            
        
                
        
