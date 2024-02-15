def solution(s, skip, index):
    dic = "abcdefghijklmnopqrstuvwxyz"
    answer = ''
    for i in skip:
        dic = dic.replace(i, '')

    for i in s:
        if (dic.index(i) + index) >= len(dic):
            answer += dic[(dic.index(i) + index) % len(dic)]
        else:
            answer += dic[dic.index(i) + index]
    return answer