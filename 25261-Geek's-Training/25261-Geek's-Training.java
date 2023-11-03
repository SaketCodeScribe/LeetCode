class Solution{
    public int maximumPoints(int points[][], int n){
        int i;
        int[] prev = new int[3], curr = new int[3], pprev = new int[3];
        
        for(i=0; i<n; i++){
            curr[0] = Math.max(prev[0], Math.max(pprev[0], Math.max(prev[1], prev[2]))+points[i][0]);
            curr[1] = Math.max(prev[1], Math.max(pprev[1], Math.max(prev[0], prev[2]))+points[i][1]);
            curr[2] = Math.max(prev[2], Math.max(pprev[2], Math.max(prev[1], prev[0]))+points[i][2]);
            pprev[0] = prev[0];
            pprev[1] = prev[1];
            pprev[2] = prev[2];
            prev[0] = curr[0];
            prev[1] = curr[1];
            prev[2] = curr[2];
        }
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
}