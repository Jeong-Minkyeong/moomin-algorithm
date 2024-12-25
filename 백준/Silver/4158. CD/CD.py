# 백준 4158(이분 탐색)

import sys
input=sys.stdin.readline

def binary_search(target, data):
    start = 0 			# 맨 처음 위치
    end = len(data) - 1 	# 맨 마지막 위치

    while (start <= end):
        mid = (start + end) // 2 # 중간값

        if (data[mid] == target):
            return mid 		# target 위치 반환

        elif (data[mid] > target): # target이 작으면 왼쪽을 더 탐색
            end = mid - 1
        else:                    # target이 크면 오른쪽을 더 탐색
            start = mid + 1
    return None

while(1):
    N, M = map(int, input().split())

    if N == 0 and M == 0:
        break

    answer = 0
    sun =[]
    sang =[]

    sun = [int(input()) for i in range(N)]
    sang = [int(input()) for i in range(M)]

    sang.sort()

    for i in sun:
        if (binary_search(i, sang) != None):
            answer += 1

    print(answer)
