def solution(board, moves):
    answer = 0
    temp = []
    for i in moves:
        for b in range(len(board)):
            if board[b][i-1] != 0 and len(temp) == 0:
                temp.append(board[b][i-1])
                board[b][i-1] = 0
                break
                
            elif board[b][i-1] != 0 and len(temp) != 0:
                if board[b][i-1] == temp[-1]:
                    temp = temp[:-1]
                    board[b][i-1] = 0
                    answer += 1
                    break
                    
                else:
                    temp.append(board[b][i-1])
                    board[b][i-1] = 0
                    break
    return answer*2
