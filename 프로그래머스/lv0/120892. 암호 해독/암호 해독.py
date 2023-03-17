def solution(cipher, code):
    answer = [cipher[c] for c in range(code-1, len(cipher), code)]
    
    return ''.join(answer)