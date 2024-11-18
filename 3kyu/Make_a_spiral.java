// 3 kyu
public class Spirale {

 public static int[][] spiralize(int size) {
        int[][] spirale = new int [size][size];
        
        //On calcule le millieu
        int middle = size/2;
        //Si il est impaire on ajoute 1.
        if(size % 2 == 1) middle +=1;
        
        //Si c'est 6,10,14,18.... On doit enlever le 1 du centre (on ne veut pas de carré central).
        if((size - 2) %4 == 0) {
        	middle += 1;
        }
        
        //On genere la partie haute impaire (premiere ligne vaut 1)
        generateUpOdd(spirale,size,middle);
        //On genere la partie haute paire (deuxieme ligne vaut 2)
        generateUpEven(spirale, size, middle);
        //On genere la partie basse impaire (derniere ligne est considérée impaire)
        generateDownOdd(spirale, size, middle);
        //On genere la partie basse paire (l'avant derniere ligne est considérée paire)
        generateDownEven(spirale, size, middle);
        
        
        return spirale;
    }
	
	public static void generateUpOdd(int[][] spirale, int size, int middle) {
		//Indice de départ
		int indS = -3;
		//Indice de fin
		int indE = size;
		
		int[] tab = new int[size];
		
		//On remplit le tableau de 1.
		for(int i = 0; i<tab.length;i++) {
			tab[i] = 1;
		}
		
		//On commence a la premiere ligne.
		int n = 1;
		while(n <= middle) {
			
			if(indS > 0) {//On change seulement si situé dans le tableau
				tab[indS] = 0;
			}
			if(indE < size) {//On change seulement si situé dans le tableau
				tab[indE] = 0;
			}
			//On creer une copie
			int[] copy = copy(tab);
			
			//On met la copie dans l'indice recalculé
			spirale[n-1] = copy;
			
			//Incrementation des indices
			indE -= 2;
			indS += 2;
			n += 2;
		}
	}
	
	public static void generateUpEven(int[][] spirale, int size, int middle) {
		//Indice de départ
		int indS = -2;
		//Indice de fin
		int indE = size-1;
		
		int[] tab = new int[size];
		
		//On remplit le tableau de 0.
		for(int i = 0; i<tab.length;i++) {
			tab[i] = 0;
		}
		
		//On commence a la deuxieme ligne.
		int n = 2;
		while(n <= middle) {
			
			if(indS >= 0) {//On change seulement si situé dans le tableau
				tab[indS] = 1;
			}
			
			tab[indE] = 1;
			//On creer une copie
			int[] copy = copy(tab);
			
			//On met la copie dans l'indice recalculé
			spirale[n-1] = copy;
			
			//Incrementation des indices
			indE -= 2;
			indS += 2;
			n += 2;
		}
	}
	
	public static void generateDownOdd(int[][] spirale, int size, int middle) {
		//Indice de départ
		int indS = -1;
		//Indice de fin
		int indE = size;
		
		int[] tab = new int[size];
		
		//On remplit le tableau de 1
		for(int i = 0; i<tab.length;i++) {
			tab[i] = 1;
		}
		
		//On commence a la derniere ligne
		int n = size;
		while(n > middle) {
			if(indS > 0) {//On change seulement si situé dans le tableau
				tab[indS] = 0;
			}
			if(indE < size) {//On change seulement si situé dans le tableau
				tab[indE] = 0;
			}
			//On creer une copie
			int[] copy = copy(tab);
			
			//On met la copie dans l'indice recalculé
			spirale[n-1] = copy;
			
			//Incrementation des indices
			indE -= 2;
			indS += 2;
			n -= 2;
		}
	}
	
	public static void generateDownEven(int[][] spirale, int size, int middle) {
		//Indice de départ
		int indS = 0;
		//Indice de fin
		int indE = size-1;
		
		int[] tab = new int[size];
		
		//On remplit le tableau de 0
		for(int i = 0; i<tab.length;i++) {
			tab[i] = 0;
		}
		
		//On commence à l'avant derniere ligne
		int n = size-1;
		while(n > middle) {
				
			tab[indS] = 1;
			tab[indE] = 1;
			
			//On creer une copie
			int[] copy = copy(tab);
			
			//On met la copie dans l'indice recalculé
			spirale[n-1] = copy;
			
			//Incrementation des indices
			indE -= 2;
			indS += 2;
			n -= 2;
		}
	}
	
	//Permet de faire une copie d'un tableau
	public static int[] copy(int[] tab) {
		int[] tabCopy = new int[tab.length];
		
		for(int i = 0;i<tab.length;i++) {
			tabCopy[i] = tab[i];
		}
		return tabCopy;
	}
}
