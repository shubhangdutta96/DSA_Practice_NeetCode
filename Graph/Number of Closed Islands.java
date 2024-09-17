class Solution {
    public int closedIsland(int[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0 && dfs(i, j, grid)) {
                    count++;
                }
            }
        }

        return count;
    }

    public boolean dfs(int i, int j, int[][] grid) {
        if(i >= grid.length || j >= grid[0].length || i < 0 || j < 0) {
            return false;
        }
        if(grid[i][j] == 1) {
            return true;
        }

        grid[i][j] = 1;

        boolean up = dfs(i-1, j, grid);
        boolean right = dfs(i, j+1, grid);
        boolean down = dfs(i+1, j, grid);
        boolean left = dfs(i, j-1, grid);

        return up && right && down && left;
    }
}
