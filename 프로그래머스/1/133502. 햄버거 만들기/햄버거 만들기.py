def solution(ingredient):
    answer = 0
    hamburger = ''
    for i in ingredient:
        hamburger += str(i)
        if hamburger[-4:] == '1231':
            answer += 1
            hamburger = hamburger[:-4]
    return answer
    