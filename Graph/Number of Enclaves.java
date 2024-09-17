class Solution {
    int count = 0;
    public int numEnclaves(int[][] grid) {
        int ans = 0;
        int m = grid.length;
        int n  = grid[0].length;

        for(int i=1; i<m-1; i++) {
            for(int j=1; j<n-1; j++) {
                count = 0;
                if(grid[i][j] == 1 && dfs(i, j, grid)) {
                    ans += count;
                }
            }
        }

        return ans;
    }

    public boolean dfs(int i, int j, int[][] grid) {
        if(i == 0 || j == 0 || i == grid.length-1 || j == grid[0].
        length-1) {
            if(grid[i][j] == 0) {
                return true;
            }
            else {
                count = 0;
                return false;
            }
        }

        if(grid[i][j] == 0) {
            return true;
        }    

        grid[i][j] = 0;
        count += 1;

        boolean up = dfs(i-1, j, grid);
        boolean right = dfs(i, j+1, grid);
        boolean down = dfs(i+1, j, grid);
        boolean left = dfs(i, j-1, grid);

        return up && right && down && left;
    }
}
