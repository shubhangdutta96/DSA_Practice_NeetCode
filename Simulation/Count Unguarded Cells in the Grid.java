class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][] = new int[m][n];
        int guard = 1;
        int wall = 2;

        for(int g[] : guards) {
            int i = g[0];
            int j = g[1];

            grid[i][j] = guard;
        }

        for(int w[] : walls) {
            int i = w[0];
            int j = w[1];

            grid[i][j] = wall;
        }

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == guard) {
                    helper(grid, i, j);
                }
            }
        }

        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 0) {
                    ans++;
                }
            }
        }

        return ans;
    }

    public void helper(int grid[][], int i, int j) {
        // west
        for(int k=i+1; k<grid.length; k++) {
            if(grid[k][j] == 2 || grid[k][j] == 1) {
                break;
            }
            grid[k][j] = -1;
        }
        // north
        for(int k=i-1; k>=0; k--) {
            if(grid[k][j] == 2 || grid[k][j] == 1) {
                break;
            }
            grid[k][j] = -1;
        }


        // east
        for(int k=j+1; k<grid[0].length; k++) {
            if(grid[i][k] == 2 || grid[i][k] == 1) {
                break;
            }
            grid[i][k] = -1;
        }
        // south
        for(int k=j-1; k>=0; k--) {
            if(grid[i][k] == 2 || grid[i][k] == 1) {
                break;
            }
            grid[i][k] = -1;
        }

        return;
    }
}
