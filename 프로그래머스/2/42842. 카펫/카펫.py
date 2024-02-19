def solution(brown, yellow):
    answer = []
    temp = [ [i, yellow//i ] for i in range(yellow+1,0,-1) if yellow % i == 0]
    temp = [i for i in temp if i[0] >= i[1]]
    for i in temp:
        tile = 4 + i[0]*2 +i[1]*2
        if tile == brown:
            return [i[0]+2, i[1]+2]