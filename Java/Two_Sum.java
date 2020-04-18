import java.util.Arrays;

public class TwoSum
{
    public static int[] twoSum(int[] numbers, int target)
    {
		//On trie la liste
        Arrays.sort(numbers);
        //L'indice du début
        int start = 0;
        //L'indice de la fin
        int end = numbers.length-1;
        int sum;
        
        while(start < end) {
        	//La somme courante
        	sum  = numbers[start] + numbers[end];
        	
        	//Si on a trouver la somme que l'on veut
        	if(sum == target) {
        		//On renvoie le resultat.
        		int[] res = new int[] {start,end};
        		return res;
        	}
        	//Si on est trop petit
        	if(sum < target) {
        		start++;
        	}
        	//Si on est trop grand
        	if(sum > target){
        		end--;
        	}
        }
        //impossible a atteindre d'apres l'énoncé.
        return null;
    }
}
