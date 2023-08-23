def solution(arr, n): 
    if len(arr) % 2 == 0:
        for i in range(len(arr)):
            if i % 2 == 0:
                arr[i+1] = arr[i+1]+n
    else:
         for i in range(len(arr)+1):
            if i % 2 != 0:
                arr[i-1] = arr[i-1]+n
                
    return arr