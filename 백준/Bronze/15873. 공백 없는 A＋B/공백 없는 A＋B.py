n = input()
total_sum = 0

for i in n:
    total_sum += int(i)
total_sum += 9 * n.count('0')

print(total_sum)
