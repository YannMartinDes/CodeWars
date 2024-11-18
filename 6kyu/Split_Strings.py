// 6 kyu
def solution(s):
    liste=[]
    for i in range(0,len(s),2):
        try:
            liste.append(s[i]+s[i+1])
        except:
            liste.append(s[i]+'_')
    return liste
