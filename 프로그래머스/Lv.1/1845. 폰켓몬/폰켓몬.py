def solution(nums):
    num = len(nums)/2
    poketmon = {}
    for i in nums:
        if i in poketmon:
            poketmon[i] += 1
            continue
        poketmon[i] = 1
    return len(poketmon) if num >= len(poketmon) else num