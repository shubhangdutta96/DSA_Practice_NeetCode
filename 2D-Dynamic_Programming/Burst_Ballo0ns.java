// MCM based

//Approach for Burst Balloons Problem:

// Array Extension: Add 1 at the start and end of the nums array to handle edge cases.
// Recursive Subproblem: Define solve(i, j) to calculate the maximum coins for bursting all balloons between indices i and j.
// Choosing the Last Balloon: For each k in [i, j], calculate the coins for bursting k last, using the formula:
// coins = newNums[i−1]×newNums[k]×newNums[j+1]+solve(i,k−1)+solve(k+1,j)

class Solution {
    public int maxCoins(int[] nums) {
        // MCM

        int newNums[] = new int[nums.length + 2];
        newNums[0] = 1;
        newNums[nums.length+1] = 1;
        for(int i=1;i<=nums.length;i++){
            newNums[i] = nums[i-1];
        }

        int t[][] = new int[newNums.length+1][newNums.length+1];
        for(int i[] : t){
            Arrays.fill(i, -1);
        }
        // 1. find (i, j) --> (i = 1, j = nums.length)
        return solve(newNums, 1, nums.length, t);
    }

    public int solve(int newNums[], int i, int j, int t[][]){

        // 2. Base case
        if(i > j){
            return 0;
        }

        if(t[i][j] != -1){
            return t[i][j];
        }

        int max = 0;

        // 3. loop k -> (i -j)
        for(int k=i;k<=j;k++){

            // 4. Calculate tempAns
            int tempAns = newNums[i-1] * newNums[k] * newNums[j+1] 
                          + solve(newNums, i, k-1, t) 
                          + solve(newNums, k+1, j, t);

            max = Math.max(max, tempAns);
        }

        return t[i][j] = max;
    }
}
