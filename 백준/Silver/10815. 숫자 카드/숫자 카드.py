# 백준 10815
import sys
input=sys.stdin.readline

def binary_search(target, data):
    start = 0
    end = len(data) - 1

    while(start <= end):
        mid = (start + end) // 2

        if(data[mid] == target):
            return mid
        
        elif(data[mid] > target):
            end = mid - 1

        else:
            start = mid + 1
    return None


answer = []

N = int(input())
card = list(map(int, input().split()))

M = int(input())
sang = list(map(int, input().split()))

card.sort()

for i in sang:
    if binary_search(i, card) != None:
        answer.append(1)
    else:
        answer.append(0)

print(' '.join(map(str, answer)))

