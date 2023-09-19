def solution(num_list):
    odd = [ num_list[i] for i in range(1, len(num_list), 2)]
    even = [ num_list[i] for i in range(0, len(num_list), 2)]
    return sum(odd) if sum(odd) > sum(even) else sum(even)