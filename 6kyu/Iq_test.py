// 6 kyu
def iq_test(numbers):
    Lnumbers = numbers.split(" ")
    
    Lodd = [odd for odd in Lnumbers if int(odd)%2 == 1]
    Leven = [even for even in Lnumbers if int(even)%2 == 0]
    
    if len(Lodd) > len(Leven) :
        return Lnumbers.index(Leven[0])+1
    else : 
        return Lnumbers.index(Lodd[0])+1
