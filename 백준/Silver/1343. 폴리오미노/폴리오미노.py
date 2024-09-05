input_board = input()
answer = ""
piece = []
start = 0

# 스플릿으로 풀어보기
for i, v in enumerate(input_board):
    if i != 0 and v != input_board[i-1]:
        piece.append(input_board[start:i])
        start = i

piece.append(input_board[start:]) 

for i in piece:
    if '.' in i:
        answer += i
        continue

    elif (len(i) % 2) != 0:
        answer = -1
        break

    answer += (len(i) // 4) * "AAAA" + (len(i) % 4 // 2) * "BB"  

print(answer)