class Solution {
    public int solve(int[] arr, int s, int e){
		int i;
		int curr, prev, pprev;
		prev = arr[s];
		pprev = 0;
		for(i=s+1; i<e; i++){
			curr = Math.max(prev, pprev+arr[i]);
			pprev = Math.max(prev, pprev);
			prev =  curr;
		}
		return prev;
	}
    public int rob(int[] valueInHouse) {
        int n = valueInHouse.length;
		return n == 1 ? valueInHouse[0] : Math.max(solve(valueInHouse, 0, n-1), solve(valueInHouse, 1, n));
    }
}