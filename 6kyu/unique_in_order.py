// 6 kyu
def unique_in_order(iterable):
    res=[]
    last=''
    for i in iterable:
        if i != last:
            res+=[i]
            last=i
    return res
