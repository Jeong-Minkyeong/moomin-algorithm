n = input()
total_sum = 0

# Calculate the sum of digits
for i in n:
    total_sum += int(i)

# If '0' is in the input string, add 9 to the sum
if '0' in n:
    total_sum += 9 * len([i for i in n if i == '0'])

print(total_sum)
