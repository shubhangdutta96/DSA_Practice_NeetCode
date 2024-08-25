// DP Relation:

// For each character pair (i, j):
// If word1[i-1] == word2[j-1], no operation is needed: t[i][j] = t[i-1][j-1].
// If they differ, consider the minimum cost among:
// Insertion: t[i][j-1] + 1        (word is decreased from word2)
// Deletion: t[i-1][j] + 1         (word is decreased from word1)
// Substitution: t[i-1][j-1] + 1   (word is decreased from both of the words)


class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int t[][] = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            t[i][0] = i;
        }
        for(int i=0;i<=n;i++){
            t[0][i] = i;
        }

        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    t[i][j] = t[i-1][j-1];
                }
                else{
                    t[i][j] = 1 + Math.min(Math.min(t[i][j-1], t[i-1][j]), t[i-1][j-1]);
                }
            }
        }

        return t[m][n];
    }
}
