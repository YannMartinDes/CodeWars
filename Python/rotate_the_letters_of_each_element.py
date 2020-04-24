# 6 kyu
def group_cities(seq):
    
    liste = [] #La liste de resultat
    find = False#Si on a trouver un match, vaut true
    
    for word in seq :#pour chaque mot a traiter
        find = False#on n'a pas trouver de match
        
        rotation = all_rotation(word)#On calcule toute les rotations du mot
        
        for s_liste in liste :#pour chaque sous listes
            #mise en minuscule
            if s_liste[0].lower() in rotation :#si un element se trouve dans les rotations 
                find = True#on a trouver un match
                if word not in s_liste :#si le mot n'a pas déjà été ajouté
                    s_liste.append(word)
                        
        if not find :#si on a rien trouver on ajoute une sous liste 
            liste.append([word])
        

    for s_liste in liste:#on trie chaque sous liste (ordre alphabétique)
        s_liste.sort()

    #on trie la liste principale par taille décroissante
    #et par ordre alphabétique en cas d'égalité de taille
    liste.sort(key=lambda x: (-len(x),x[0].lower()))
    
    return liste

def all_rotation(word): #Calcule toutes les rotations d'un mot

    liste = []
    w = word.lower()
    while liste == [] or w != word.lower() :
        liste += [w]
        w = w[-1]+w[0:-1]
        
    return liste
