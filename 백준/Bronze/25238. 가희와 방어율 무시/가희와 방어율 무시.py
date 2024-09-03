a, b = map(int, input().split())

era = a * ((100-b)/100)
if era >= 100:
    print(0)
else:
    print(1)