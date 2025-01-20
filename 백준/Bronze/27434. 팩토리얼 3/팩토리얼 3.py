# 백준 27434 - 팩토리얼

N = int(input())
answer = 1

for i in range(1, N+1, 1):
    answer *= i
print(answer)
