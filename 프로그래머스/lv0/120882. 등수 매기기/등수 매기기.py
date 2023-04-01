import numpy as np

def solution(score):
    answer = [ np.mean(i) for i in score]
    answer_sorted = sorted(answer, reverse = True)
    return [answer_sorted.index(i)+1 for i in answer]


