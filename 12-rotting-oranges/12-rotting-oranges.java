class Solution {
    public int orangesRotting(int[][] grid) {
        int m =grid.length, n = grid[0].length, i, j, qsize, ans = 0, sum=0;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        for(i=0; i<m ; i++){
            for(j=0; j<n; j++){
                if (grid[i][j] == 1)
                    sum = 1;
                else if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                    vis[i][j] = true;
                }
            }
        }
        if (sum == 0)
            return ans;
        while(queue.size()>0){
            qsize = queue.size();
            while (qsize-- > 0){
                i = queue.peek()[0];
                j = queue.peek()[1];
                queue.poll();
                if (i+1 < m && j<n && !vis[i+1][j] && grid[i+1][j] == 1){
                    queue.add(new int[]{i+1, j});
                    vis[i+1][j] = true;
                }
                if (i > 0 && j<n && !vis[i-1][j] && grid[i-1][j] == 1){
                    queue.add(new int[]{i-1, j});
                    vis[i-1][j] = true;
                }
                if (i < m && j+1<n && !vis[i][j+1] && grid[i][j+1] == 1){
                    queue.add(new int[]{i, j+1});
                    vis[i][j+1] = true;
                }
                if (i < m && j > 0 && !vis[i][j-1] && grid[i][j-1] == 1){
                    queue.add(new int[]{i, j-1});
                    vis[i][j-1] = true;
                }       
            }
            if (queue.size() > 0)
                ans++;
        }
        for(i=0; i<m ; i++)
            for(j=0; j<n; j++)
                if(grid[i][j] == 1 && !vis[i][j])
                    return -1;
        return ans;
    }
}