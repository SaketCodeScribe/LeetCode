class Solution {
    public void solve(char[][] board) {
        int m = board.length, n = board[0].length, i, j;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        
        for(i=0; i<m; i++){
            for(j=0; j<n; j++){
                if((i == 0 || j == 0 || i == m-1 || j == n-1) && board[i][j] != 'X'){
                    vis[i][j] = true;
                    queue.add(new int[]{i, j});
                }
            }
        }
        while(queue.size() > 0){
            i = queue.peek()[0];
            j = queue.poll()[1];
            if (i+1 < m && board[i][j] != 'X' && !vis[i+1][j]){
                queue.add(new int[]{i+1, j});
                vis[i+1][j] = true;
            }
            if (j+1 < n && board[i][j] != 'X' && !vis[i][j+1]){
                queue.add(new int[]{i, j+1}); 
                vis[i][j+1] = true;
            }
            if (j > 0 && board[i][j] != 'X' && !vis[i][j-1]){
                queue.add(new int[]{i, j-1});
                vis[i][j-1] = true;
            }
            if (i > 0 && board[i][j] != 'X' && !vis[i-1][j]){
                queue.add(new int[]{i-1, j});
                vis[i-1][j] = true;
            }
        }
        for(i=0; i<m; i++){
            for(j=0; j<n; j++)
                if (!vis[i][j])
                    board[i][j] = 'X';
        }
    }
}