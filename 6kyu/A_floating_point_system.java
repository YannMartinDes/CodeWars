import java.math.BigDecimal;

// 6 kyu
public class A_floating_point_system {
	
	public static String mantExp(BigDecimal aNumber, int digitsNumber) {
		//On recupere la partie entiere et decimale sous forme de string
		String intPart = aNumber.toBigInteger().toString();
		String fracPart = aNumber.remainder(BigDecimal.ONE).toString();
		
		if(!fracPart.equals("0")) {//Si il y a une partie decimale;
			fracPart = fracPart.substring(2);//On la recupere en enlevant le "0."
		}
		
		int intLength =0;//La longueur de la partie entiere.
		int fracLength = 0;//La longueur de la partie décimale.
		int fracBegin = 0;//L'index du premier chiffre != 0 dans la partie decimale.
		
		//Si la partie entiere existe.
		if( (intPart.charAt(0) != '0' && intPart.length() == 1) 
				|| intPart.length() > 1) {
			intLength = intPart.length();//On recupere sa longueur.
		}
		
		int i = 0;
		//Tant que l'on rencontre des 0 dans la partie décimale.
		while(i < fracPart.length() && fracPart.charAt(i) == '0') {
			i++;
		}
		
		if(i != fracPart.length()) {//Si n'y a pas que des 0.
			fracBegin = i;// on recupere l'index du premier chiffre
			fracLength = fracPart.length();//On recupere la longueur totale.
		}
		
		int power = -digitsNumber + intLength;//On calcule la puissance.
		if(intLength == 0) {//Si il n'y a pas de partie entiere.
			power -= fracBegin;//La on ajoute la puissance négative de la partie décimale.
		}
		
		i=0;
		int j = 0;
		String res = "";
		
		//Tant que l'on est dans la partie entiere et on est plus petit que le nombre de chiffre demandé.
		while(i < intLength && i < digitsNumber) {
			res += intPart.charAt(i);
			i++;
		}
		
		if(intLength == 0) {//Si il n'y a pas de partie entiere
			j = fracBegin;//On ignore les 0 et commence dès le premier chiffre.
		}
		
		//Tant que l'on est dans la partie décimale et on est plus petit que le nombre de chiffre demandé.
		while(j < fracLength && i < digitsNumber) {
			res += fracPart.charAt(j);
			i++; j++;
		}
		//On ajoute des 0 jusqu'au nombre de chiffre demandé.
		while(i<digitsNumber) {
			res += '0';
			i++;
		}
		res += "P"+power;//On ajoute la puissance.
		
		return res;
    }
}
