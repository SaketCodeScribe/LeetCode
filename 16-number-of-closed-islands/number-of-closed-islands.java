class Solution {

    public int closedIsland(int[][] grid) {
      int i, j, m = grid.length, n = grid[0].length, ans = 0;
			int[][] dirs = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
			boolean[][] vis = new boolean[m][n];
			Queue<int[]> queue = new LinkedList<int[]>();
			
			for(i=0; i<m; i++) {
				for(j=0; j<n; j++) {
					if (!vis[i][j] && grid[i][j] == 0) {
						queue = new LinkedList<int[]>();
						queue.add(new int[] {i,j});
						vis[i][j] = true;
						boolean flag = true;
						while (!queue.isEmpty()) {
							int r = queue.peek()[0], c = queue.poll()[1];
							if(grid[r][c] == 1)
								continue;
							for(var dir:dirs) {
								if (r+dir[0] < 0 || r+dir[0] >= m || c+dir[1] < 0 || c+dir[1] >= n){
									flag = false;
									continue;
								}
								if (!vis[r+dir[0]][c+dir[1]])
									queue.add(new int[] {r+dir[0],c+dir[1]});
								vis[r+dir[0]][c+dir[1]] = true;
							}
						}
						if (flag)
							ans++;
					}
				}
			}
			return ans;
    }
}