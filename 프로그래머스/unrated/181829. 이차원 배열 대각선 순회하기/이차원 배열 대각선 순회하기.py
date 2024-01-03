def solution(board, k):
    answer = []
    for i, v in enumerate(board):
        for i2, v2 in enumerate(v):
            if i+i2 <= k:
                answer.append(v2)
    return sum(answer)