// 6 kyu
def tribonacci(signature, n):
    res=[]
    for i in range(n):
        if i<=2:
            res.append(signature[i])
        else:
            res.append(res[i-3]+res[i-2]+res[i-1])
    return res
