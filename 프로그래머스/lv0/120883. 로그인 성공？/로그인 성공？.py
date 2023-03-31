def solution(id_pw, db):
    answer = dict(db)
    if id_pw[0] in answer.keys():
        
        if id_pw[1] == answer[id_pw[0]]:
            
            return "login"
            
        else:
            return "wrong pw"
        
    else:
        return "fail"
        
      