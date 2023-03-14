def solution(price):
    
    if 0 < price < 100000:
        return price
    
    elif 100000 <= price < 300000:
        price -= (price*(0.05))
        return int(price)
    
    elif 300000 <= price < 500000:
        price -= (price*(0.1))
        return int(price)

    elif price >= 500000:
        price -= (price*(0.2))
        return int(price)
   