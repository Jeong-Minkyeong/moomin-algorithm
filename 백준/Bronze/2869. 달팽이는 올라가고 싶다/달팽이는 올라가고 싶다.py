import math

day, night, v = map(int, input().split())

answer = v - day 
print(math.ceil(answer/(day-night))+1)
