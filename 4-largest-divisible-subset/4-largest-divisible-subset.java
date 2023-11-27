class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int i, j, lsd = 1, pos = 0, n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] dp = new int[n];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Arrays.fill(dp, 1);
        Arrays.sort(nums);
        
        map.put(nums[0],-1);
        for(i=1; i<n; i++){
            map.put(nums[i], -1);
            for(j=0; j<i; j++){
                if (nums[i] % nums[j] == 0 && dp[i] < dp[j]+1)
                    map.put(nums[i],j);
                dp[i] = Math.max(dp[i], nums[i] % nums[j] == 0 ? dp[j]+1 : dp[i]);
                if (lsd < dp[i]){
                    lsd = dp[i];
                    pos = i;
                }
            }
        }
        while (pos>-1){
            ans.add(nums[pos]);
            pos = map.get(nums[pos]);
        }
        return ans;
    }
}