def solution(my_string, is_suffix):
    answer = my_string[-len(is_suffix):]
    return 1 if answer == is_suffix else 0