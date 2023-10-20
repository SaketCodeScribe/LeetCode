class Solution {
	private int MOD = (int) Math.pow(10, 9) + 7;

	public long count(long[][] table, int[] nums){
        int n = nums.length; 
        if (n <= 1)
            return 1;
        int root = nums[0];
        List<Integer> left = new ArrayList<Integer>(), right = new ArrayList<Integer>();
        for(int i=1; i<n; i++){
            if (nums[i] < root)
                left.add(nums[i]);
            else
                right.add(nums[i]);
        }
        return (table[n-1][left.size()]*count(table, left.stream().mapToInt(Integer::intValue).toArray())%MOD*count(table, right.stream().mapToInt(Integer::intValue).toArray())%MOD)%MOD;
    }


	public int numOfWays(int[] nums) {
		int i, j, n = nums.length;
        
		long[][] table = new long[n][n];
        for (i = 0; i < n; ++i) {
            table[i][0] = table[i][i] = 1;
        }
        for (i = 2; i < n; i++) {
            for (j = 1; j < i; j++) {
                table[i][j] = (table[i - 1][j - 1] + table[i - 1][j]) % MOD;
            }
        }
		return (int)count(table, nums)-1;
	}
}