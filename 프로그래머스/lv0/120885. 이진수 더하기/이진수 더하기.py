def solution(bin1, bin2):
    bin1 = [int(v)*(2**i) for i, v in enumerate(reversed(bin1))]
    
    bin2 = [int(v)*(2**i) for i, v in enumerate(reversed(bin2))]
    answer = sum(bin1+bin2)
    return format(answer, 'b')