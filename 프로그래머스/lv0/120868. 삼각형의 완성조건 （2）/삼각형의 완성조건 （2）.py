def solution(sides):
    answer = [ i for i in range(max(sides)) if i+min(sides) >= max(sides) ]
    answer = [ i for i in range(max(sides)-min(sides)+1, sum(sides)) if max(sides)+1 <= sum(sides) ]
    return len(answer)

# 가장 긴 변 내부 -> sum(나머지두변)+1~가장긴변
# 가장 긴 변 외부 -> 가장 긴변+1 ~ sum(나머지두면)-1 