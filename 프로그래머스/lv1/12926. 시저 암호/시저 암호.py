def solution(s, n):
    lowercase =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z']
    uppercase = [i.upper() for i in lowercase]
    answer = []
    for i in s:
        if i == ' ':
            answer.append(i)
            
        elif i.isupper():
            if uppercase.index(i)+n > 25:
                e = (uppercase.index(i)+n) - 26
                answer.append(uppercase[e])
            else:
                answer.append(uppercase[uppercase.index(i)+n])
                
            
        elif i.islower():
            if lowercase.index(i)+n > 25:
                e = lowercase.index(i)+n - 26
                answer.append(lowercase[e])
            else:
                answer.append(lowercase[lowercase.index(i)+n])
            
    return ''.join(answer)