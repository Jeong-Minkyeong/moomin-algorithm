n, m = map(int, input().split())
answer = 0
if n == 0:
    pass

else:
    book_list = list(map(int, input().split()))
    answer = 1
    box = 0

    for b in book_list:
        box += b

        if box > m:
            box = b
            answer += 1
    
print(answer)
