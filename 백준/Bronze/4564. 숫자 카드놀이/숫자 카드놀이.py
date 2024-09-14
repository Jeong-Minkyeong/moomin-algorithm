def func(number):
     card = 1
     for i in str(number):
        card *= int(i) 
     return card


while(1):
    num = input()
    if num == '0':
        break
    while(len(str(num)) > 1):
        print(num, end = ' ')
        num = func(num)
    print(num)