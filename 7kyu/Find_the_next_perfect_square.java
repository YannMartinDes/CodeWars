//Kyu 7
public class NumberFun {
	public static long findNextSquare(long sq) {
		long i = (long) Math.sqrt(sq);
		if((i*i) == sq){
			i++;
			return (i*i);
		}
		return -1; 
	}
}
