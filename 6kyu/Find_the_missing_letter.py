// 6 kyu
def find_missing_letter(chars):
    Alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
    Begin = chars[0]
    for i in range(len(Alpha)):
        if Alpha[i] == Begin :
            i_begin = i
    j = 0
    while Alpha[i_begin] == chars[j]:
        i_begin += 1
        j += 1
    return Alpha[i_begin]
