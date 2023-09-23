num_list = []

while(1):
    word = input()
    if word == '0':
        break
    num_list.append(word)

for i in num_list:
    word_reverse = i[::-1]
    if i == word_reverse:
        print('yes')
    else:
        print('no')