def solution(my_string):
    vowel = ['a', 'e', 'i', 'o', 'u']
    for c in vowel:
        my_string = my_string.replace(c, '')
    return my_string