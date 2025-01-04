answer = list(map(lambda x : int(x)**2, input().split()))
print(sum(answer)%10)