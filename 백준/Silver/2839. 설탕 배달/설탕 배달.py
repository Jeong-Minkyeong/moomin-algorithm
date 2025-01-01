# 백준 2839번(그리디)
# 봉지는 3키로와 5키로  
# 5로 나누어 떨어지던지
# 5와 3의 조합으로 나눠지던지
# 3으로 나누어 떨어지던지
# 그냥 나눠지지 않던지 

n = int(input())
answer = 0

while(1):
    if n < 0:
        print(-1)
        break

    elif n % 5 != 0:
        n -= 3
        answer += 1
        
    elif n % 5 == 0:
        answer += (n // 5)
        print(answer)
        break