n = int(input())
answer = []

for _ in range(n):
    x, y = map(int, input().split())
    answer.append([x,y])

answer.sort()
for i in range(n):
    print(*answer[i])