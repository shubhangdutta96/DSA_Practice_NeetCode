class Solution {
    public int maxDepth(String s) {
        int nest = 0;
        int ans = 0;
        char ch[] = s.toCharArray();

        for(char c : ch) {
            if(c == '(') {
                nest++;
            } else if(c == ')') {
                ans = Math.max(ans, nest);
                nest--;
            }
        }

        return ans;
    }
}
