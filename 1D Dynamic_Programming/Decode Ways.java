class Solution {
    int count;
    public int numDecodings(String s) {
        int[] t = new int[s.length()+1];
        Arrays.fill(t, -1);
        count = 0;
        return countWays(s, 0, t);
    }

    public int countWays(String s, int len, int t[]){
        if(len == s.length()){
            return 1;
        }

        if (s.charAt(len) == '0') {
            return 0;
        }

        if (t[len] != -1) {
            return t[len];
        }

        int one = countWays(s, len+1, t);
        
        int two = 0;
        if(len + 1 < s.length() && Integer.parseInt(s.substring(len, len+2)) <= 26){
            two = countWays(s, len+2, t);
        }

        t[len] = one + two;
        return t[len];
    }
}
