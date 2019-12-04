// 6 kyu
def tickets(people):     #people is a list like [25,25,50]
    banknote25=0
    banknote50=0
    for i in people:
        if i==25:
            banknote25+=1
        elif i==50:
            banknote25-=1
            banknote50+=1
        elif i==100:
            if banknote50 !=0:
                banknote25-=1
                banknote50-=1
            else:
                banknote25-=3
        if banknote50<0 or banknote25<0 :
            return "NO"
    return "YES"
