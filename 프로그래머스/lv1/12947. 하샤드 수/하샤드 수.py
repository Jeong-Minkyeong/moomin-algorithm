def solution(x):
    
    answer = [ int(i) for i in str(x)]
    answer = sum(answer)
    return True if x % answer == 0 else False