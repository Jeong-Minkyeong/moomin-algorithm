def solution(num_list):
    even = [str(i) for i in num_list if i % 2 == 0]
    odd = [str(i) for i in num_list if i % 2 != 0]
    return int(''.join(odd)) + int(''.join(even))