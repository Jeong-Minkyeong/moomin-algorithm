## 백준 11399

people = int(input())
atm_time = list(map(int, input().split()))
answer = 0

atm_time.sort()

for i in range(people):
    answer += sum(atm_time[:i+1])

print(answer)