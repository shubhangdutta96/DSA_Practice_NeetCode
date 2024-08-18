class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        // make a 'DP TABLE' of 'int'
        // 'store 1 as TRUE and 0 as FALSE'
        // initialized all with -1(memoization)
        int t[][] = new int[s.length()+1][s.length()+1];
        for(int i[] : t){
            Arrays.fill(i, -1);
        }
        return solve(s, 0, 0, wordDict, t);
    }

    public boolean solve(String s, int start, int end, List<String> wordDict, int t[][]){
        // memoization
        if(t[start][end] != -1){
            return t[start][end] == 1 ? true : false;
        }
        
        if(end == s.length()-1){
            if(wordDict.contains(s.substring(start, end+1))){
                t[start][end] =  1;
                return true;
            }
            return false;
        }
// Decisions:
// If the current substring s[start:end+1] is found in the dictionary, decide whether to "include" this substring as part of the solution (i.e., move the start to end+1) or continue extending the substring (end+1).
        if(wordDict.contains(s.substring(start, end+1))){
            // 1. decision: "include" this substring as part of the solution
            if(solve(s, end+1, end+1, wordDict, t)){
                t[start][end] = 1;
                return true;
            }
        }
        // 2. decision: continue extending the substring(end+1), keeping the start same
        boolean ans = solve(s, start, end+1, wordDict, t);
        t[start][end] = ans == true ? 1 : 0;

        return t[start][end] == 1 ? true : false;
    }
}
