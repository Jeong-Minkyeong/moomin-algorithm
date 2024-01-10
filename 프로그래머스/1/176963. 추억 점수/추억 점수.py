def solution(name, yearning, photo):
    yearning_dic = dict(zip(name, yearning))
    answer = []
    score = 0
    for p in photo:
        for i in p:
            if i not in yearning_dic:
                continue
            score += yearning_dic[i]
        answer.append(score)
        score = 0
    return answer