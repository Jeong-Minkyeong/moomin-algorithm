def solution(s):
    count = 0
    s = list(s)
    for i in range(len(s)):
        if s[i] == ' ':
            count = 0
        else:
            count += 1
            
            if count == 0 or count % 2 == 0:
                s[i] = s[i].lower()
            else:
                s[i] = s[i].upper()
    return ''.join(s)