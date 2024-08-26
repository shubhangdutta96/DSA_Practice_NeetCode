// Approach:
// Recursive Matching: The function solve recursively checks if s[i:] matches p[j:] using dynamic programming to store results in a 2D table t.

// Base Cases:

// If both i and j reach the end of s and p, it's a match (return 1).
// If p is exhausted but s isn't, return 0 (no match).
// Match Condition: Check if the current characters in s and p match or if p[j] is ..

// Handling '*':

// If the next character in p is *, there are two options:
// Skip the '*' pattern (solve(s, p, i, j + 2)).
// Use '*' to match one or more characters in s if there's a match (solve(s, p, i + 1, j)).
// Direct Match:

// If characters match, move both pointers forward (solve(s, p, i + 1, j + 1)).

class Solution {
    public boolean isMatch(String s, String p){
        int [][] t = new int[s.length()+1][p.length()+1];
        for(int i[] : t){
            Arrays.fill(i, -1);
        }

        return solve(s, p, 0, 0, t) == 1;
    }

    public int solve(String s, String p, int i, int j, int[][] t){
        // base case
        if(i >= s.length() && j >= p.length()){
            return t[i][j] = 1;
        }
        if(j >= p.length()){
            return t[i][j] = 0;
        }
        if(t[i][j] != -1){
            return t[i][j];
        }

        boolean match = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        
        if(j+1 < p.length() && p.charAt(j+1) == '*'){
            t[i][j] = (solve(s, p, i, j + 2, t) == 1 || (match && solve(s, p, i + 1, j, t) == 1)) ? 1 : 0;
        }

        else if(match){
            t[i][j] = solve(s, p, i+1, j+1, t);
        }
        
        else{
            t[i][j] = 0;
        }

        return t[i][j];
    }
}
