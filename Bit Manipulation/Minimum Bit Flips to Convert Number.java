class Solution {
    public int minBitFlips(int start, int goal) {
        int count = 0;
        if(start > goal) {  // make goal always greater than start
            return minBitFlips(goal, start);
        }

        while(goal != 0) {
            int lastOfS = start % 2;
            int lastOfG = goal % 2;

            if(lastOfS != lastOfG) {
                count++;
            }

            start /= 2;
            goal /= 2;
        }

        return count;
    }
}
