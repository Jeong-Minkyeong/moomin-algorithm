def solution(price, money, count):
    answer = [price*i for i in range(1, count+1)]
    answer = sum(answer)
    return abs(money-answer) if money-answer < 0 else 0