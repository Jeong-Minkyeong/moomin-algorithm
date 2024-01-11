def solution(k, score):
    hall_of_fame = []
    answer = []
    for i in score:
        hall_of_fame.append(i)
        hall_of_fame.sort(reverse = True)
        if len(hall_of_fame) > k:
            hall_of_fame.pop()
        answer.append(min(hall_of_fame))
    return answer