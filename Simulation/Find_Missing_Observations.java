// Key Logic of the Solution:

// Calculate the total number of rolls:
// The total number of rolls (both observed and missing) is (rolls.length + n).

// Calculate the required sum for the missing rolls:
// The required sum for the missing rolls is the difference between the target total sum (mean * total) and the sum of the observed rolls.

// Handle invalid cases:
// If required is negative or greater than n * 6 (which means it's impossible to achieve with n rolls), or if n > required (impossible since each roll must be at least 1), return an empty array.

// Distribute the sum:
// First, distribute the base value start = required / n to all missing rolls.
// Then, distribute the remainder (required % n) by adding 1 to the first few rolls.

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int ans[] = new int[n];
        int sum = 0;
        int total = rolls.length + n;

        for(int i=0; i<rolls.length; i++) {
            sum += rolls[i];
        }

        int required = (mean * total) - sum;
        if(required < 0 || required > n*6 || n > required){
            return new int[0];
        }

        int x = 6;
        int sum2 = 0;
        int size = n;
        int start = required / n;
        int add = required % n;

        for(int i=0; i<n; i++){
            ans[i] = start;
        }
        for(int i=0; i<add; i++){
            ans[i]++;
        }

        return ans;
    }
}
