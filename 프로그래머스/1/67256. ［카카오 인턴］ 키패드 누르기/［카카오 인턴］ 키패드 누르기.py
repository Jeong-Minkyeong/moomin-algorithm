def solution(numbers, hand):
    answer = ''
    keypad = { 1 : [0,0], 2 : [0,1], 3 : [0,2],
               4 : [1,0], 5 : [1,1], 6 : [1,2],
               7 : [2,0], 8 : [2,1], 9 : [2,2],
              '*': [3,0], 0 : [3,1],'#': [3,2]}
    hands = { 'left' : '*', 'right' : '#'}

    for i in numbers:
        if keypad[i][1] == 0:
            answer += 'L'
            hands['left'] = i
            
        elif keypad[i][1] == 2:
            answer += 'R'
            hands['right'] = i
        
        else:
            left_p = abs(keypad[i][0] - keypad[hands['left']][0]) + abs(keypad[i][1] - keypad[hands['left']][1])
            right_p = abs(keypad[i][0] - keypad[hands['right']][0]) + abs(keypad[i][1] - keypad[hands['right']][1])
            
            if left_p == right_p:
                answer += hand.upper()[0]
                hands[hand] = i
                
                
            elif left_p > right_p:
                answer += 'R'
                hands["right"] = i
    
            else:   
                answer += 'L'
                hands["left"] = i      

    return answer

# 123
# 456
# 789
# *0#