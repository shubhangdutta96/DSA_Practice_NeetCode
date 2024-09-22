class Solution {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] != 0) {
                    
                    int curr = dfs(i, j, grid);
                    max = Math.max(max, curr);
                }
            }
        }

        return max;
    }

    public int dfs(int i, int j, int[][] grid) {
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0) {
            return 0;
        }
        if(grid[i][j]==0) {
            return 0;
        }

        int currentValue = grid[i][j];
        grid[i][j] = 0;

        int up = dfs(i-1, j, grid);
        int right = dfs(i, j+1, grid);
        int down = dfs(i+1, j, grid);
        int left = dfs(i, j-1, grid);

        grid[i][j] = currentValue;

        return currentValue + Math.max(Math.max(up, right), Math.max(down, 
        left));
    }
}
