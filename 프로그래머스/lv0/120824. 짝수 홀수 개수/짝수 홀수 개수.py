'''def solution(num_list):
    answer = [0,0]
    for n in num_list:
        answer[n%2]+=1
    return answer'''

def solution(num_list):
    answer = []
    answer1 = [i for i in num_list if i%2 == 0]
    answer2 =  [i for i in num_list if i%2 != 0]
    answer.append(len(answer1))
    answer.append(len(answer2))
    return answer