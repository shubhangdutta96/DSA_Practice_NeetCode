class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins.length == 1) {
            if (amount == 0) {
                return 0; // No coins needed to make amount 0
            }
            if (coins[0] > amount || amount % coins[0] != 0) {
                return -1; // Impossible to make the amount
            }
            return amount / coins[0]; // Minimum coins needed
        }
        // Unbounded-knapsack
        int t[][] = new int[coins.length+1][amount+1];

        // initialization
        for(int j=0;j<=amount;j++){
// let us suppose we have some  amount, but having 0 coins, so we require infinte coins to get that amount.
            t[0][j] = Integer.MAX_VALUE-1;  

// let us suppose, we have amount of 4 and having coin 3, we can't make amount 4 with coin 3, so there again we require infinite coins to get that amount.
            if(j % coins[0] != 0){
                t[1][j] = Integer.MAX_VALUE-1;  
            }
            else{
                t[1][j] = j/coins[0];
            }
        }

        // simple unbounded-knapsack
        for(int i=2;i<=coins.length;i++){
            for(int j=1;j<=amount;j++){
                if(coins[i-1] <= j){
                    t[i][j] = Math.min(1+t[i][j-coins[i-1]], t[i-1][j]);
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }        

        return t[coins.length][amount] == Integer.MAX_VALUE-1 ? -1 : t[coins.length][amount];
    }
}
