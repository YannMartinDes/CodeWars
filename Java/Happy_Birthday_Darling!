// 7 kyu
public class HappyBirthdayDarling {
	public static String womensAge(int n) {
		//La puissance actuelle
		int m = 2;
		String res;
	
		while(true) {
			//Si n est compris entre 2*m et 2*m+1 (entre 20 et 21 dans la représentation de la base m)
			if(n <= 2*m+1 && n >= 2*m) {
				
				int p0 = n%(m*2);//On trouve la puissance 0 de m;
				//La puissance 1 de m doit forcement être 2.
				res = n+"? That's just 2"+p0+", in base "+m+"!";
				
				return res;//on retourne le resultat.
			}
			//On incremente la puissance.
			m++;
		}
	}
}
