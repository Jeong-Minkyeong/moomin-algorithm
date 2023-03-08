def solution(babbling):
    answer = []
    word = ["aya", "ye", "woo", "ma"]
    for w in babbling:
        for i in word:
            if (w.find(i)) != -1:
                w = w.replace(i, '0')
        answer.append(w)
    result = ' '.join(s for s in answer)
    result = result.replace('0', '')
    result = result.split()
    return len(babbling) - len(result)