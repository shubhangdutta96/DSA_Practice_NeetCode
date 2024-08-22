class Solution {
    public int numDistinct(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int t[][] = new int[m+1][n+1];
        for(int i=0;i<s1.length();i++){
            t[i][0] = 1;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1] + t[i-1][j];
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[m][n];
    }
}
