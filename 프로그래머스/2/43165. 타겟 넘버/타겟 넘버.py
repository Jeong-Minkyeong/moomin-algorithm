def func(numbers, num, target, index):
    if index == len(numbers):
        if num == target:
            return 1
        else:
            return 0
    
    return func(numbers, num+numbers[index], target, index+1) + func(numbers, num-numbers[index], target, index+1)

def solution(numbers, target):
    num = 0
    index = 0    
    return func(numbers, num, target, index)