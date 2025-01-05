# 백준 28062번 (그리디)

N = int(input())
candy = sorted(list(map(int, input().split())))
answer = sum(candy)

if answer % 2 != 0:
    for i in candy:
        if i % 2 != 0:
            answer -= i
            break

print(answer)
