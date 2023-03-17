def solution(rsp):
    win = {"2" : "0", "0" : "5", "5":"2"}
    answer = [ win[i] for i in rsp]
    return ''.join(answer)