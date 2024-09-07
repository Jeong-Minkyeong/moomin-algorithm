num = int(input())
input_student = list(map(int, input().split()))
answer = 0

for i, v in enumerate(input_student):
    if i+1 != v:
        answer += 1

print(answer)