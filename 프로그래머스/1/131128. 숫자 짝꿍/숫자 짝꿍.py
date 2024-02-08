def solution(X, Y):
    answer = ''
    X_count = [0 for i in range(10)]
    Y_count = [0 for i in range(10)]
    
    for i in X:
        X_count[int(i)] += 1
    
    for i in Y:
        Y_count[int(i)] += 1
    
    for i in range(9, -1, -1):
        if X_count[i] >= 1 and Y_count[i] >= 1:
            answer += str(i)*min(Y_count[i], X_count[i])
            
    if len(answer) == 0:
        return "-1"
    if answer[0] == "0":
        return "0"
    else:
        return answer