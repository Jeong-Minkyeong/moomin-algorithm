def solution(common):
    
    if common[1]-common[0] == common[-1]-common[-2]:
        return common[0]+(common[1]-common[0])*(len(common))
    else:
        return common[0]*((common[1]//common[0])**(len(common)))


# a + rn
# ar^n-1