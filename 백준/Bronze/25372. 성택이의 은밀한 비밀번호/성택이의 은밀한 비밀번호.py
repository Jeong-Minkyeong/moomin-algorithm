num = int(input())

for i in range(num):
    password = input()
    if (6 <= len(password) <= 9):
        print("yes")
    else:
        print("no")
