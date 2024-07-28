N = int(input())
s_list = list(map(int, input().split()))
print(*sorted(set(s_list)))