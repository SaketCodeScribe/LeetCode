import java.util.* ;
import java.io.*; 
public class Solution {
	private static final int MOD = (int)Math.pow(10,9)+7;
	public static int countDistinctWayToClimbStair(long nStairs) {
		long i, curr, prev = 1, pprev = 1;
		for(i=2; i<=nStairs; i++){
			curr = (prev+pprev)%MOD;
			pprev = prev;
			prev = curr;
		}
		return (int)prev;
	}
}