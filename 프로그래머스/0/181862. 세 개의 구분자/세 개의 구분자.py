def solution(myStr):
    myStr = myStr.replace('b', 'a')
    myStr = myStr.replace('c', 'a')
    answer = myStr.split('a')
    answer = [ i for i in answer if i != ""]
    return ["EMPTY"] if len(answer) == 0 else answer