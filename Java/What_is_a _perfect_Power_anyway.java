// 5 kyu
public class What_a_Perfect_Power_anyway {
	
	public static int[] isPerfectPower(int n) {
		//La racine de m.
		float m = 2;
		// 0 et 1 ne sont pas des carrés parfait
		if(n == 0 || n == 1) return null;
		
		while(true) {
			//On calcule le resultat obtenue. 
			double val = Math.pow(n, (1f/m));
			//Si cette valeur est un carré parfait
			if(Math.pow(Math.round(val), m) == n) return new int[]{(int) val,(int) m};
			//Si le carré est plus petit que 2, on ne trouveras plus de carré parfait ? 
			if(val < 2) return null;
			
			m++;
		}
	}
}
