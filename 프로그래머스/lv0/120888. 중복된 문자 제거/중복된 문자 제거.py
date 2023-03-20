def solution(my_string):
    new_string =[]
    for w in list(my_string):
        if w not in new_string:
            new_string.append(w)
    return ''.join(new_string)