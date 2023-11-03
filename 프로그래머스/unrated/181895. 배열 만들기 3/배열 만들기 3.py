def solution(arr, intervals):
    list_1 = [arr[i] for i in range(intervals[0][0],intervals[0][1]+1)]
    list_2 = [arr[i] for i in range(intervals[1][0],intervals[1][1]+1)]
    return list_1+list_2