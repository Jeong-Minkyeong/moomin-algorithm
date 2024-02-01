def solution(s):
    answer = 0
    x_count = 0
    temp_count = 0
    x = ''

    while(len(s) > 0):
        x = s[0]
        for i in s:
            if i == x:
                x_count += 1
            else:
                temp_count += 1
            
            if x_count == temp_count:
                break
        s = s[x_count+temp_count:]
        answer += 1
        x_count = 0
        temp_count = 0
        
    return answer