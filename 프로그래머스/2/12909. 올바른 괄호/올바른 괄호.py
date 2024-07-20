# 2nd

def solution(s):
    temp = []
    size = len(s)
    for i in s:
        if len(temp) == 0:
            temp.append(i)
        elif temp[-1]+i == '()':
            temp.pop()
        else:
            temp.append(i)
    print(temp)
    return True if len(temp)==0 else False
        