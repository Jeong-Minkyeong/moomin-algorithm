s = int(input())
cnt = 0
answer = 0

while cnt<=s:
    answer += 1
    cnt = cnt + answer

print(answer - 1)