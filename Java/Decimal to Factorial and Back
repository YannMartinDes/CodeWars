// 5 kyu 
public class Dec2Fact {
	
	public static long fact(int n){
		
		if(n == 0) return 1;
		
		long res = 1;
		for(int i = 1; i <= n; i++) {
			res = res * i;
		}
		return res;
	}
	
  
	public static String dec2FactString(long nb) {
		char[] alpha = new char[]{'0','1','2','3','4','5','6','7','8','9',
				'A','B','C','D','E','F','G','H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		int n = 36;
		long fact = fact(n);
		
		while(nb/fact == 0) {
			n--;
			fact = fact(n);
		}
		
		String res = "";
		while(n > 0) {	
			if(nb/fact > n) {
				res += alpha[n];
				nb = nb%n;
			}
			else {
				res += alpha[(int) (nb/fact)];
				nb = nb%fact;
			}
			n--;
			fact = fact(n);
		}
		res += 0;
		
		return res;
	}


	public static long factString2Dec(String str) {
		long res = 0;
		int n = 0;
		
		for(int i = str.length()-1; i>=0; i--) {
			char c = str.charAt(i);
			if(c > 57 ) {
				res += (c -55) * fact(n);
			}
			else {
				res += (c-48) * fact(n);
			}
			n++;
		}
		return res;
	}
}
