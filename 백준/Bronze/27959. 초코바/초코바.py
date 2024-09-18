
def snack(n, m):
    if (n*100) >= m:
        print("Yes")
    
    else:
        print("No")

    return

n, m = map(int, input().split())
snack(n, m)
    