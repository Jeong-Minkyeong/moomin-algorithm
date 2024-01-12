def solution(a, b):
    month = 0
    answer = ["FRI","SAT","SUN","MON","TUE","WED","THU"]
    calendar = {1:31, 2:29, 3:31, 4:30, 5:31, 6:30, 7:31, 8:31, 9:30, 10:31, 11:30, 12:31}
    for i in range(1,a):
        month += calendar[i]
    return answer[(month+b)%7-1]
