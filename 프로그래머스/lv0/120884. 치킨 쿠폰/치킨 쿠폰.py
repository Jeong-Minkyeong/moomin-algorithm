def solution(chicken):
    answer = 0
    while(chicken != 0):
        c, coupon = divmod(chicken, 10)
        answer += c
        chicken = (c + coupon)
        if chicken < 10:
            break
    
    return answer