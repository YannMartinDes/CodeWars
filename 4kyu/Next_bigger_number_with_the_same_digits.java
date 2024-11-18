// 4 kyu
public class Next_bigger_number_with_the_same_digits {

	public static long nextBiggerNumber(long n)
	{
		
		/* O(n) Algoritm */
		
		//On convertit le long en string (on aurait pu en int[])
		String n_string = Long.toString(n);
		int i = n_string.length()-1;// i = dernier chiffre;

		while( i > 0 //Tant que n'est pas le premier chiffre [o(n)]
				&& ((int) n_string.charAt(i)) <= ((int) n_string.charAt(i-1)))//Et que n[i] <= n[i-1]
			i--;//On decremente i;

		if(i == 0) return -1;//Si i est le dernier, il n'y a pas de nombre plus grand avec les memes chiffres.

		int j = n_string.length()-1;// j = dernier chiffre;
		int m = i-1;//m est l'indice avant i

		//Tant que n[m] >= n[j]
		while(((int) n_string.charAt(m)) >= ((int) n_string.charAt(j))) // [o(n)]
			j--;//On decremente j;
 
		//Le while se termine obligatoirement.
		n_string = swap(n_string, m, j);//On echange n[m] et n[j]

		int l = n_string.length()-1;// l = dernier chiffre;

		//Ici on inverse toute la chaine de caractère de i à la fin.
		while(i < l) {//Tant que i est inferieur a l [o(n)]
			n_string = swap(n_string, i, l);//On echange
			i++;
			l--;
		}

		return Long.parseLong(n_string);//On reconvertit
	}

	public static String swap(String s,int ind1, int ind2) { // [o(n)]
		char c1 = s.charAt(ind1);//Le caractere à l'indice ind1
		char c2 = s.charAt(ind2);//Le caractere à l'indice ind2

		StringBuffer stringBuffer = new StringBuffer(s);//Pour pouvoir set.
		stringBuffer.setCharAt(ind1, c2);//On échange les deux chiffres
		stringBuffer.setCharAt(ind2, c1);

		return stringBuffer.toString();//On retourn la nouvelle chaine de caractères
	}
}
