//6 kyu
public class Diamond {

	public static String print(int n) {
		//Si n est pair ou négatif on retourne null.
		if(n%2 == 0 || n < 0) return null;
		
		String res = "";//le resultats
		int middle = n/2;//Le millieu. 
		int stars = 1;//Le nombre d'etoile a afficher
		int blank;//Le nombre d'espace a afficher
		int i;//Variable de boucle
		
		for(int j = 0; j < n; j++) {
			//On calcule le nombre d'espace a mettre
			blank = (n - stars)/2;
			//On ajoute le nombre d'espace
			for(i =0; i<blank; i++) {
				res += " ";
			}
			//On ajoute le nombre d'etoile
			for(i =0; i<stars; i++) {
				res += "*";
			}
			//On finit par un retour à la ligne.
			res += "\n";
			//Si on est en dessous du millieu on doit augmenter le nombre d'etoile
			if(j < middle) stars += 2;
			//Sinon on les reduits.
			else stars -= 2;		
		}
		return res;
	}
}
