class Solution {
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        long max = nums[0];
        long total = nums[0];

        for(int i=1; i<n; i++) {
            total += nums[i]; 
            max = Math.max(max, (total+i) / (i+1));
        }

        return (int) max;     
    }
}
