// The problem checks if s3 is an interleaving of s1 and s2 by using a 2D DP table to ensure that the characters from s1 and s2
// appear in s3 in the correct order while covering all characters.

class Solution{
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()){
            return false;
        }
        boolean[][] t = new boolean[s1.length()+1][s2.length()+1];

        // base cases
        t[0][0] = true; // an empty s1 and s2 can interleave to form an empty s3
        for(int i=1;i<=s1.length();i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && t[i-1][0] == true){
                t[i][0] = true;
            }
        }
        for(int i=1;i<=s2.length();i++){
            if(s2.charAt(i-1) == s3.charAt(i-1) && t[0][i-1] == true){
                t[0][i] = true;
            }
        }

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if((s1.charAt(i-1) == s3.charAt(i+j-1) && t[i-1][j] == true) || 
                    (s2.charAt(j-1) == s3.charAt(i+j-1) && t[i][j-1] == true)){
                    t[i][j] = true;
                }
            }
        }

        return t[s1.length()][s2.length()];
    }
}
