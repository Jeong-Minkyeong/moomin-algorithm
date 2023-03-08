'''def solution(n, k):
    service = n//10
    drink = max(0, k-service)
    return (12000*n)+(2000*drink)'''

def solution(n, k):
    answer = 0
    if n < 10:
        answer = (12000*n+2000*k)
        return answer
    elif n >= 10:
        s = n//10
        anwser = (12000*n+2000*(k-s))
        return anwser