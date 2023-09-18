import sys

N = int(sys.stdin.readline())
num = [int(sys.stdin.readline())for i in range(N)]
answer = sorted(num)
for i in answer:
    print(i)
