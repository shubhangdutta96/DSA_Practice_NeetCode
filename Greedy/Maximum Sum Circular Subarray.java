class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int globalMax = nums[0];
        int globalMin = nums[0];
        int total = nums[0];

        for(int i=1; i<nums.length; i++) {
            total += nums[i];

            currMax += nums[i];
            if(nums[i] > currMax) {
                currMax = nums[i];
            }

            currMin += nums[i];
            if(nums[i] < currMin) {
                currMin = nums[i];
            }

            if(currMax > globalMax) {
                globalMax = currMax;
            } 
            if(currMin < globalMin) {
                globalMin = currMin;
            }
        }

        return globalMax > 0 ? 
        Math.max(globalMax, total - globalMin) : globalMax;
    }
}
