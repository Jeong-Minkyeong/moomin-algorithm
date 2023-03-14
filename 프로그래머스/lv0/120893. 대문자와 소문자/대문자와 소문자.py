def solution(my_string):
    answer = [ w.lower() if w.isupper() else w.upper() for w in my_string ]
    
    return ''.join(answer)