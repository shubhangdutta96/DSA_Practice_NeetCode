// very-easy problem:
// DFS + Memoization

class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int t[][] = new int[matrix.length][matrix[0].length];
        for(int i[] : t){
            Arrays.fill(i, -1);
        }
        int max = 0;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                max = Math.max(max, dfs(matrix, i, j, -1, t));
            }
        }

        return max;
    }

    public int dfs(int[][] matrix, int i, int j, int prev, int[][] t){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prev){
            return 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }

        int up = 1;
        int right = 1;
        int down = 1;
        int left = 1;
        up += dfs(matrix, i-1, j, matrix[i][j], t);
        right += dfs(matrix, i, j+1, matrix[i][j], t);
        down += dfs(matrix, i+1, j, matrix[i][j], t);
        left += dfs(matrix, i, j-1, matrix[i][j], t);

        return t[i][j] = Math.max(Math.max(up, down), Math.max(left, right));
    }
}
