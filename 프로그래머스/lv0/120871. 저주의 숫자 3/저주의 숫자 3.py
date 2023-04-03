def solution(n):
    answer = 0
    plus = 1
    for i in range(0 , n):
        answer += 1
        while(1):
            if answer % 3 == 0 or '3' in str(answer):
                answer += plus
            else:
                break
    return answer

