class Solution {
	public static long ayushGivesNinjatest(int n, int m, int[] time) {
        // Write your code here.
        long low = Arrays.stream(time).max().getAsInt() , high = Arrays.stream(time).sum(), mid;
        while(low<high){
            mid = low+(high-low)/2;
            if (isPossible(n, mid, time))
                high = mid;
            else
                low = mid+1;
        }
        return isPossible(n, high, time) ? high : -1;
	}
	
	private static boolean isPossible(int n, long mid, int[] times) {
			long day = 1, t=0;
			for(int time:times) {
				if (t+time <= mid)
					t += time;
				else {
					day++;
					if(time > mid || day > n)
						return false;
					t = time;
				}
			}
			return true;
		}
}
