def solution(num_list):
    answer = []
    answer1 = [i for i in num_list if i%2 == 0]
    answer2 =  [i for i in num_list if i%2 != 0]
    answer.append(len(answer1))
    answer.append(len(answer2))
    return answer