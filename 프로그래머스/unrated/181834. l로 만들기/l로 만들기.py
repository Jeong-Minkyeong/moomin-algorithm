def solution(myString):
    alpha = 'abcdefghijklmnopqrstuvwxyz'
    for i in myString:
        if alpha.index(i) < alpha.index('l'):
            myString = myString.replace(i, 'l')
    return myString