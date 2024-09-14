word = input()
vowel = ['a', 'e', 'i', 'o', 'u']
answer = 0

for i in word:
  if i in vowel:
    answer += 1

print(answer)