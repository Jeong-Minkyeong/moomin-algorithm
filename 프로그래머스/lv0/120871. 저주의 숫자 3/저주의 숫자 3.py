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
# 3 6 9 12 13  3 3+3 13
# 3 6 9 12 13 15   6 15+6 21 
# 3 6 9 12 13 15 18 21 23 24 
