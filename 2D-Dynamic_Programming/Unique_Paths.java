class Solution {
    public int uniquePaths(int m, int n) {
        int t[][] = new int[m][n];
        for(int i[] : t){
            Arrays.fill(i, -1);
        }
        return dfs(0, 0, t);
    }

    public int dfs(int i, int j, int[][] t){
        if(i >= t.length || j >= t[0].length){
            return 0;
        }
        if(i == t.length-1 && j == t[0].length-1){
            return 1;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }

        int ans1 = dfs(i, j+1, t); // right
        int ans2 = dfs(i+1, j, t); // down

        return t[i][j] = ans1 + ans2;
    }
}
