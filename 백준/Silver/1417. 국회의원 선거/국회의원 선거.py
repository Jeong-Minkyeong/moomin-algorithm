n = int(input())
vote = []

for _ in range(n):
    vote.append(int(input()))

dasom = vote[0]

if n == 1:
    another = 0
else:
    another = sorted(vote[1:], reverse=True)

while(another != 0):
    if dasom > max(another):
        break

    dasom += 1
    another[0] -= 1
    another.sort(reverse = True)
answer = dasom - vote[0]

print(answer)
