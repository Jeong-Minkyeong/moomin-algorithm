n = int(input())

spot = list(map(int, input().split()))
distance = 0

for i in range(n):
  for j in range(i+1, n):
    distance += abs(spot[i] - spot[j])

print(distance*2)