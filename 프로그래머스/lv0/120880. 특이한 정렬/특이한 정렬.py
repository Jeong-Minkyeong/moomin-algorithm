def solution(numlist, n):
    answer = [ {"index" : i, "value" : abs(n-i) } for i in numlist]
    #dic = { key : value for key, value in zip(numlist,answer)}
    answers = sorted(answer, key = lambda x : (x["value"], -x["index"]))
    return [ i["index"] for i in answers ]

    
    