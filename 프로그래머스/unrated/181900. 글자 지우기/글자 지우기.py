def solution(my_string, indices):
    for i in indices:
        answer = [ my_string[i] for i in range(len(my_string)) if i not in indices]
    return ''.join(answer)
    