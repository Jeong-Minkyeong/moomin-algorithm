def solution(my_string):
    my_string = my_string.split()
    cur = [ i for i in my_string if i == "+" or i == "-"]
    my_string = [ int(i) for i in my_string if i not in cur]
    
    for i, v in enumerate(cur):
        if v == "+":
            my_string[i+1] = my_string[i]+my_string[i+1]
            
        elif v == "-":
            my_string[i+1] = my_string[i]-my_string[i+1]
            
    return my_string[-1]
