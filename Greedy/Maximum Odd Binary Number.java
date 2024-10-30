class Solution {
    public String maximumOddBinaryNumber(String s) {
        char ch[] = s.toCharArray();
        int ones = 0;

        for(char c : ch) {
            if(c == '1') {
                ones++;
            }
        }

        StringBuilder str = new StringBuilder("");
        for(int i=0; i<ch.length-1; i++) {
            if(ones > 1) {
                ones--;
                str.append('1');
            } else {
                str.append('0');
            }
        }

        return str.append('1').toString();
    }
}
