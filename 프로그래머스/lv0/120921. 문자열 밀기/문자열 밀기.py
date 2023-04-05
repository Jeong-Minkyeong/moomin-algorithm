from collections import deque

def solution(A, B):
    
    count = 1
    if A == B:
        return 0
    
    answer = deque(list(A))
    while(count < len(A)):
        answer.rotate(1)
        if ''.join(answer) == B:
            return count
        count += 1
        
    return -1
        