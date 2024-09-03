input_chess = list(map(int, input().split()))
chess = [1,1,2,2,2,8]
answer = []

for i in range(6):
    print(chess[i] - input_chess[i])
