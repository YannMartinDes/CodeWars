// 6 kyu
def count(string):
    # The function code should be here
    res = {}
    for letter in string :
        if letter not in res :
            res[letter] = 1
        else :
            res[letter] += 1
    return res
