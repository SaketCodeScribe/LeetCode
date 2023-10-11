import java.util.* ;
import java.io.*; 
/*
	This is signature of helper function 'knows'.
	You should not implement it, or speculate about its implementation.

	boolean knows(int A, int B); 
	Function 'knows(A, B)' will returns "true" if the person having
	id 'A' know the person having id 'B' in the party, "false" otherwise.
	Use it as Runner.knows(A, B);
*/
	
public class Solution {
	public static int findCelebrity(int n) {
		int i, ans = 0;
		for(i=1; i<n; i++){
			if (Runner.knows(ans, i))
				ans = i;
		}
		for(i=0; i<n; i++){
			if (ans != i && (!Runner.knows(i,ans) || Runner.knows(ans, i)))
				return -1;
		}
		return ans;
    }
}