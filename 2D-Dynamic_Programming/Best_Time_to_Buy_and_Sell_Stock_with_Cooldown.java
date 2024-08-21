// Recursive Approach (TLE):

class Solution {
    public int maxProfit(int[] prices) {
        return solve(prices, 0, 1);
    }

    public int solve(int[] prices, int i, int canBuy){
        // base case 
        if(i >= prices.length){
            return 0;
        }

// if we can buy  2 options: 
// 1. Buy and move to next day, now we can't buy
// 2/ Skip the day and move to next day (to get max profit)

        if(canBuy == 1){
            int buy = -prices[i] + solve(prices, i+1, 0);  // Buy and move to next day, now we can't buy

            int skip = solve(prices, i+1, 1);  // Skip the day and move to next day

            return Math.max(buy, skip);
        }
        

// if can't buy means we have already a stock in stock  again we have 2 options:
// 1. sell and move to day after the next (cooldown) and now we can buy
// 2. Skip selling and move to the next day 

        else{
            int sellAndCoolDown = prices[i] + solve(prices, i+2, 1); // Sell and move to day after the next (cooldown)

            int skip = solve(prices, i+1, 0); // Skip selling and move to the next day  
        
            return Math.max(sellAndCoolDown, skip);
        }
    }
}

// Memoization:

class Solution {
    public int maxProfit(int[] prices) {
        int t[][] = new int[prices.length][2];
        for(int i[] : t){
            Arrays.fill(i, -1);
        }

        return solve(prices, 0, 1, t);
    }

    public int solve(int[] prices, int i, int canBuy, int[][] t){
        // base case 
        if(i >= prices.length){
            return 0;
        }

        if(t[i][canBuy] != -1){
            return t[i][canBuy];
        }

// if we can buy  2 options: 
// 1. Buy and move to next day, now we can't buy
// 2/ Skip the day and move to next day (to get max profit)

        if(canBuy == 1){
            int buy = -prices[i] + solve(prices, i+1, 0, t);  // Buy and move to next day, now we can't buy

            int skip = solve(prices, i+1, 1, t);  // Skip the day and move to next day

            return t[i][canBuy] =  Math.max(buy, skip);
        }
        

// if can't buy means we have already a stock in stock  again we have 2 options:
// 1. sell and move to day after the next (cooldown) and now we can buy
// 2. Skip selling and move to the next day 

        else{
            int sellAndCoolDown = prices[i] + solve(prices, i+2, 1, t); // Sell and move to day after the next (cooldown)

            int skip = solve(prices, i+1, 0, t); // Skip selling and move to the next day  
        
            return t[i][canBuy] =  Math.max(sellAndCoolDown, skip);
        }
    }
}
