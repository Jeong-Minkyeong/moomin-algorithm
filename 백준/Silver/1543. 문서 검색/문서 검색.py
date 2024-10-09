words = input()
word = input()
answer = 0

while(1):
    if word in words:
        answer += 1
        i = words.index(word)
        words = words[i+len(word):]

    else:
        break
print(answer)
