def solution(hp):
    attack = {1:5, 2:3, 3:1}    
    a, b = divmod(hp, attack[1] )
    c, d = divmod(b, attack[2] )
    e, f = divmod(d, attack[3] )
    answer = a+c+e
    return answer