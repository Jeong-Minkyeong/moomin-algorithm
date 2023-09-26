import sys

N = int(input())
num = [0 for i in range(10001)]

for i in range(N):
    inputNum = int(sys.stdin.readline())
    num[inputNum] += 1

for i, v in enumerate(num):
    if v > 0:
        for j in range(v):
            print(i)
    
