class Solution {
    public boolean canPartition(int[] nums) {
        // 0/1 Knapsack problem
        int sum = 0;
        for(int i : nums){
            sum += i;
        }

        
        if(sum % 2 != 0){
            return false;
        }

        int W = sum / 2;
        boolean t[][] = new boolean[nums.length+1][W+1];
        for(int i=0;i<=nums.length;i++){
            t[i][0] = true;
        }

        for(int i=1;i<=nums.length;i++){
            for(int j=1;j<=W;j++){
                if(nums[i-1] <= j){
                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j]; 
                }
                else{
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[nums.length][W];
    }
}
