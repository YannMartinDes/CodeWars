// 6 kyu
def countBits(n):
    q=-1
    res=""
    acc=0
    while q !=0:
        q=n//2
        r=n%2
        res=str(r)+res
        n=q
    print(res)
    for i in res:
        if i =='1':
            acc+=1
    return acc
