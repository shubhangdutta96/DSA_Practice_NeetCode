class Solution {
    public int islandPerimeter(int[][] grid) {
        int count = 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    count = dfs(grid, i, j, 0);
                    break;
                }
            }
        }

        return count;
    }

    public int dfs(int[][] grid, int i, int j, int ans){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0){
            return 1;
        }

        if(grid[i][j] == 2){
            return 0;
        }
        grid[i][j] = 2;

        int count = 0;
        count += dfs(grid , i-1, j, count);
        count += dfs(grid , i, j+1, count);
        count += dfs(grid , i+1, j, count);
        count += dfs(grid , i, j-1, count);

        return count;
    }
}
