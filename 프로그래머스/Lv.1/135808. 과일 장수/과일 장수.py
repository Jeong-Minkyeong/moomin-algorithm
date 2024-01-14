def solution(k, m, score):
    score.sort(reverse = True)
    apple_box = [score[i] for i in range(0, len(score) - len(score)%m)]
    apple_price = [ m*apple_box[i] for i in range(m-1, len(apple_box), m)]
    return sum(apple_price)