import java.util.* ;
import java.io.*; 
public class Solution 
{
	public static ArrayList<Integer> jumpingNumbers(int n){
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(0);

		for(int i=1; i<=9; i++){
			if (i <= n);
				queue.add(i);
		}

		while(!queue.isEmpty()){
			int num = queue.poll();
			if (num%10 == 0)
				queue.add(num*10+(num%10+1));
			else if (num%10 == 9)
				queue.add(num*10+(num%10-1));
			else{
				queue.add(num*10+(num%10-1));
				queue.add(num*10+(num%10+1));
			}
			if (num <= n)
				ans.add(num);
			else
				break;
		}
		return ans;
	}
}