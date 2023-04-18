def solution(arr1, arr2):
    answers = []
    for i in range(len(arr1)):
        answer = [ arr1[i][a] + arr2[i][a] for a in range(len(arr1[0]))]
        answers.append(answer)
    return answers