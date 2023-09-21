import sys

N = int(input())

answer = list(map(int, sys.stdin.readline().split()))
print(min(answer), max(answer))