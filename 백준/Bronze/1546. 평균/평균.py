N = int(input())

score = list(map(int, input().split()))

max_score = max(score)

answer = [ i/max_score*100 for i in score]

print(sum(answer)/len(answer))