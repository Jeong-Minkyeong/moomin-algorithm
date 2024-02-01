def solution(lottos, win_nums):
    lotto = { 6:1, 5:2, 4:3, 3:4, 2:5, 1:6, 0:6}
    lottos.sort()
    win_nums.sort()
    answer = [0,0]
    for i in lottos:
        if i in win_nums:
            answer[0] += 1
            answer[1] += 1
    answer[0] += lottos.count(0)
    answer[0] = lotto[answer[0]]
    answer[1] = lotto[answer[1]]
    return answer
