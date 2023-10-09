import java.util.ArrayList;

public class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k){
        int low = boards.stream().min(Integer::compareTo).get(), high = boards.stream().reduce(0, (a,b) -> a+b), mid;

        while (low < high){
            mid = low+(high-low)/2;
            if (noOfPainters(boards,mid,k) <= k)
                high = mid;
            else
                low = mid+1;
        }
        return high;
    }

	private static int noOfPainters(ArrayList<Integer> boards, int mid, int k) {
		int painter = 1, time = 0;
		for(Integer board:boards) {
			if (time+board <= mid)
				time += board;
			else {
				painter++;
				if (board > mid || painter > k)
					return Integer.MAX_VALUE;
				time = board;
			}
		}
		return painter;
	}
}