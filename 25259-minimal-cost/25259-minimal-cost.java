class Solution{
    public int minimizeCost(int arr[],int n,int k){
        int i, j, m, cost;
        int[] pre = new int[k+1];
        cost = 0;
        
        for(i=1; i<n; i++){
            cost = Integer.MAX_VALUE;
            for(j=1; j<=k && i-j >= 0; j++)
                cost = Math.min(cost, pre[Math.min(i,k)-j+1]+Math.abs(arr[i]-arr[i-j]));
            if (i >= k)
                for(j=1; j<k; j++)
                    pre[j] = pre[j+1];
            pre[j] = cost;
        }
        return cost;
    }
}