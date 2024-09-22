# 백준 1439

s = input()
one = [x for x in s.split('0') if x != '']
zero = [x for x in s.split('1') if x != '']

print(min(len(one), len(zero)))
