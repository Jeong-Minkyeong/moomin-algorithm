def solution(survey, choices):
    result = {'R' : 0, 'T': 0, 'C':0, 'F':0, 'J':0, 'M':0, 'A':0, 'N':0}
    answer = 'RCJA'
    for i, v in enumerate(survey):
        if choices[i] < 4:
            result[v[0]] += 4-choices[i]
        
        elif choices[i] > 4:
            result[v[1]] += choices[i]-4
            
    if result['T'] > result['R']:
        answer = answer.replace('R', 'T')
    
    if result['F'] > result['C']:
        answer = answer.replace('C', 'F')
        
    if result['M'] > result['J']:
        answer = answer.replace('J', 'M')
    
    if result['N'] > result['A']:
        answer = answer.replace('A', 'N')
        
    #print(result)
    return answer