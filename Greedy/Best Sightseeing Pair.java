class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int val[] = new int[values.length];

        // array for values[i] + i
        for(int i=0; i<val.length; i++) {
            val[i] = values[i] + i;
        }

        int max = Integer.MIN_VALUE;
        int x = Integer.MIN_VALUE;

        for(int i=val.length-2; i>=0; i--) {  
            // for last index there's violation of (i<j), j is going out of bounds

            x = Math.max(x, values[i+1]-(i+1)); // max (values[j] - j) so far

            max = Math.max(max, val[i]+x);  // maxx answer (values[i] + i) + (values[j] - j)
        }

        return max;
    }
}
