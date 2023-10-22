class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int i, cnt=0, n = seq.length();
        int[] ans = new int[n];

        for(i=0; i<n; i++){
            if (seq.charAt(i) == '('){
                ans[i] = cnt%2;
                cnt++;
            }
            else{
                cnt--;
                ans[i] = cnt%2;
            }
        }
        return ans;
    }
}