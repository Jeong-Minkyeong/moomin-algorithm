def solution(date1, date2):
    date_1 = [str(i) for i in date1]
    date_2 = [str(i) for i in date2]
    return 1 if int(''.join(date_1)) < int(''.join(date_2)) else 0