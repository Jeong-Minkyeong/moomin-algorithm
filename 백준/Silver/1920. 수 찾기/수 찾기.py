# 입력
N = int(input())
n_list = list(map(int, input().split()))
M = int(input())
m_list = list(map(int, input().split()))

n_list.sort()

for i in m_list:
    start, end = 0, N-1
    isExist = False
    
    while start <= end:
        medium = (start+end) // 2
        if i == n_list[medium]:
            isExist = True
            print(1)
            break
        elif i > n_list[medium]:
            start = medium + 1
        else:
            end = medium - 1
    if not isExist:
        print(0)
 