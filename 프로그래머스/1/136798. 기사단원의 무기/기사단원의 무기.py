def is_measure(x):
    measure_nums = []
    for i in range(1, int(x**0.5)+1):
        if x % i == 0:
            measure_nums.append(i)
            if i != x//i:
                measure_nums.append(x//i)
    return len(measure_nums)
        

def solution(number, limit, power):
    knight = [is_measure(i) for i in range(1, number+1)]
    for i, v in enumerate(knight):
        if v > limit:
            knight[i] = power
    return sum(knight)