def solution(A,B):
    a = sorted(max(A, B), reverse = True)
    b= sorted(min(A, B))
    
    answer = [ a[i] * b[i] for i in range(len(A))]
    return sum(answer)