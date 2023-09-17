num = int(input())
word = [input() for i in range(num)]

words = list(set(word))

words_count = [[i, len(i)] for i in words]
words_count.sort(key = lambda x:(x[1], x[0]))

for i in words_count:
    print(i[0])