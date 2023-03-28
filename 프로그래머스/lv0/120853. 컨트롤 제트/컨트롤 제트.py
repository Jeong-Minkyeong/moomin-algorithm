def solution(s):
    answer = s.split()
    for i, v in enumerate(answer):
        if v == "Z":
            answer[i] = "0"
            answer[i-1] = "0"
    return sum([int(n) for n in answer ])
    