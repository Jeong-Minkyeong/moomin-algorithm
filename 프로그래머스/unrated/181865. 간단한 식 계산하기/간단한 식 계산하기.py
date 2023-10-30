def solution(binomial):
    binomial_list = binomial.split(" ")
    if binomial_list[1] == '+':
        answer = int(binomial_list[0]) + int(binomial_list[2])
        
    elif binomial_list[1] == '-':
        answer = int(binomial_list[0]) - int(binomial_list[2])
        
    elif binomial_list[1] == '*':
        answer = int(binomial_list[0]) * int(binomial_list[2])
        
    return answer