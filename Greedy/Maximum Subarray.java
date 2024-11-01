class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;

        for(int num : nums) {
            sum += num;
            ans = Math.max(ans, sum);
            if(sum < 0) {
                sum = 0;
            }
        }

        return ans;
    }

        // one more better appraoch
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Either extend the existing subarray or start a new subarray at nums[i]
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // Update the maximum sum so far
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar;
    }
}
