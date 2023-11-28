def solution(s):
    alpha_dic = { "zero":'0', "one":'1', "two":'2',  "three":'3', "four":'4', "five":'5', "six":'6', "seven":'7', "eight":'8', "nine":'9'}
    alpha = list(alpha_dic.keys())
    for i in alpha:
        if i in s:
            s = s.replace(i, alpha_dic.get(i))
    return int(s)