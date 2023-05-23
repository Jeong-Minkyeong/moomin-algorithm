def solution(s):
    answer = [0,0]
    new_s = 0
    
    while(len(s) > 1):
        new_s = s.replace('0', '')
        answer[0] += 1
        answer[1] += len(s) - len(new_s)
        s = str(bin(len(new_s))[2:])

    
    return answer

# 0 갯수 저장 -> 0 제거
# 바이너리 변환 -> str 변환
# 반복문&조건문 적절히