class Solution{
    int[][][] dp;
    int[] c = new int[]{-1,0,1};
    
    int maxChocolate(int[][]grid, int n, int m, int i, int j, int v){
        if (i == n-1)
            return (j!=v ? grid[i][j]+grid[i][v]:grid[i][j]);
        if (dp[i][j][v] != -1)
            return dp[i][j][v];
        int ans = -10000000;
        for(int k=0; k<3; k++){
            int i_ = i+1, j_ = j+c[k];
            for(int l=0; l<3; l++){
                int v_ = v+c[l];
                if(i_<n && j_>=0 && v_>=0 && j_< m && v_<m)
                    ans = Math.max(ans, (j!=v ? grid[i][j]+grid[i][v]:grid[i][j])+
                                        maxChocolate(grid,n,m,i_,j_,v_));
            }
        }
        return dp[i][j][v] = ans;
    }
    public int solve(int n, int m, int grid[][]){
        dp = new int[n][m][m];
        Arrays.stream(dp).forEach(arr -> Arrays.stream(arr).forEach(a -> Arrays.fill(a,-1)));
        
        return maxChocolate(grid,n,m,0,0,m-1);
    }
}