def solution(board, h, w):
    answer = 0
    hw_color = board[h][w]
    dh, dw = [0, 1, -1, 0], [1, 0, 0, -1]
    
    for i in range(4):
        h_check, w_check = h + dh[i], w + dw[i]
        if (0 <= h_check < len(board)) and (0 <= w_check < len(board)):
            if board[h_check][w_check] == hw_color:
                answer += 1
    return answer
    