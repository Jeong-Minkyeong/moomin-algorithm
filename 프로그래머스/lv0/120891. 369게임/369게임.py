def solution(order):
    game = ['3', '6', '9']
    answer = [ n for n in str(order) if n in game]
    return len(answer)