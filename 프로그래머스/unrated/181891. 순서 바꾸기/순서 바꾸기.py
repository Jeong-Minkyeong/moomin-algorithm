def solution(num_list, n):
    list_1 = [num_list[i] for i in range(0,n)]
    list_2 = [num_list[i] for i in range(n, len(num_list))]
    return list_2+list_1