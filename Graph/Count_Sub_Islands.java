class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0; 

        for(int i=0;i<grid2.length;i++){
            for(int j=0;j<grid2[0].length;j++){
                if(grid2[i][j] == 1){
                    if(dfs(grid1, grid2, i, j)){
                        ans ++; 
                    }
                }
            }
        }

        return ans;
    }

    public boolean dfs(int [][] grid1, int [][] grid2, int i, int j){
        // base case 
        if(i < 0 || i >= grid2.length || j < 0 || j >= grid2[0].length || grid2[i][j] == 0){
            return true;
        }

//      Note:  if all the cells in an island in the second grid if they are represented by land in the first grid then 
//      they are connected hence making that island a sub-island
        
        if(grid2[i][j] == 1 && grid1[i][j] == 0){
            // not connected, no increase in count
            return false;
        }
        grid2[i][j] = 0;
        boolean ans = true;

        boolean up =  dfs(grid1, grid2, i-1, j); // up
        boolean right =  dfs(grid1, grid2, i, j+1); // right
        boolean down =  dfs(grid1, grid2, i+1, j); // down
        boolean left =  dfs(grid1, grid2, i, j-1); // left

      // The current island in grid2 is a sub-island only if all connected parts are valid
        return up && right && down && left;
    }
}
