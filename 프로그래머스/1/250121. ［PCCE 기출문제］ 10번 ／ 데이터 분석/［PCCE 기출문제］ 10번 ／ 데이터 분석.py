def solution(data, ext, val_ext, sort_by):
    answer = [[]]
    label = {'code': 0, 'date' : 1, 'maximum':2, 'remain':3}
    
    #data에서 ext 값이 val_ext보다 작은 데이터만 뽑기
    answer = [ i for i in data if i[label[ext]] < val_ext]
    
    #sort_by에 해당하는 값을 기준으로 오름차순으로 정렬
    answer.sort(key=lambda x:x[label[sort_by]])
    
    return answer