def solution(my_strings, parts):
    answer = [v[parts[i][0]:parts[i][1]+1] for i, v in enumerate(my_strings)]
    return ''.join(answer)