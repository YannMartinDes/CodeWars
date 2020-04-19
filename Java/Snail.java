//4 kyu
public class Snail {

	public static int[] snail(int[][] array) {
		
		//La direction de notre escargot.
		boolean goRight = true;//On commence toujours vers la droite
		boolean goLeft = false;
		boolean goDown = false;
		boolean goUp = false;
		//On recupere la taille
		int size = array.length;

		//Si le tableau est vide on retourne un tableau vide
		if(size == 0 || array[0].length == 0) return new int[0];

		//On construit notre tableau de taille size x size
		int[] res = new int[size*size]; 
		//La taille de notre matrice
		int top = 0;//Le haut
		int bottom = size;//Le bas
		int left = 0;//La gauche
		int right = size;//La droite

		//L'indice courant dans la matrice
		int i =0; int j=0; 
		int n = 0; //L'indice du tableau résultat.

		while(true) {//Boucle infinie
			
			if(goRight) {//Si on va a droite
				
				if(j >= right) break;//Cas d'arret 

				while(j < right) {//Tant qu'on peut aller a droite
					//On ajoute le resultat et on incremente
					res[n] = array[i][j];
					j++;
					n++;
				}
				
				top++;//On raccourcit le haut
				i++;//On ne recompte pas la case ou on s'est arreter dans la descente
				j--;//On est aller trop loin on reviens dans le tableau.
				//On va maintenant en bas.
				goRight = false;
				goDown = true;
			}
			
			else if(goDown) {//Si on descend

				if(i >= bottom) break;//Cas d'arret

				while(i < bottom) {//Tant qu'on peut descendre
					//On ajoute le resultat et on incremente
					res[n] = array[i][j];
					i++;
					n++;
				}
				
				right--;//On raccourcis la droite
				j--;//On ne recompte pas la case ou on s'est arrete.
				i--;//On est aller trop loin
				//On va maintenant a gauche.
				goDown = false;
				goLeft = true;
			}
			
			else if(goLeft) {//Si on va a gauche
				
				if(j < left) break;//Cas d'arret

				
				while(j >= left) {//Tant qu'on peut aller a gauche
					//On ajoute le resultat et on incremente
					res[n] = array[i][j];
					j--;
					n++;
				}
				bottom--;//On raccourcis le bas
				i--;//On ne pas compte pas la case ou on s'est arrete.
				j++;//On est aller trop loin
				//On va maintenant vers le haut.
				goLeft = false;
				goUp = true;
			}
			
			else if(goUp) {//Si on monte

				if(i < top) break;//Cas d'arret

				while(i >= top) {//Tant qu'on peut monter
					//On ajoute le resultat et on incremente
					res[n] = array[i][j];
					i--;
					n++;
				}
				left++;//On raccourcis la gauche
				j++;//On ne recompte pas la cases on s'est arreter
				i++;//On est aller trop loin.
				//On recommence en allant a droite.
				goUp = false;
				goRight = true;
			}
		}
		//On ne peut plus avancer on retourne le tableau resultat.
		return res;
	} 
}
