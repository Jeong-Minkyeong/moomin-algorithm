def solution(n, arr1, arr2):
    map = ""
    answer = []
    arr1_int = []
    arr2_int = []
    
    for i in range(n):
        arr1_int.append("{0:0{1}b}".format(arr1[i], n))
        arr2_int.append("{0:0{1}b}".format(arr2[i], n))
    
    for i in range(n):
        for j in range(n):
            if arr1_int[i][j] == '1' or arr2_int[i][j] == '1':
                map += '#'
            else:
                map += ' '
        answer.append(map)
        map = ''
    return answer