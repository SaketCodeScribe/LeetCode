class Solution {
    public int rob(int[] arr) {
        int i, n = arr.length, prev = -1, curr, pprev = 0;
        prev = arr[0];
        
        for(i=1; i<n; i++){
            curr = Math.max(pprev+arr[i], prev);
            pprev = prev;
            prev = curr;
        }
        return prev;
    }
}