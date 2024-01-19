def solution(N, stages):
    fail_percent = {}
    user = 0
    for i in range(1, N+1):
        if stages.count(i) == 0:
            fail_percent[i] = 0
            continue
        fail_percent[i] = stages.count(i) / (len(stages) - user)
        user += stages.count(i)
    answer = [i[0] for i in sorted(fail_percent.items(), key= lambda item:item[1], reverse=True)]
    return answer
