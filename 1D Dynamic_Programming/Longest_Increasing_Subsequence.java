class Solution {
    int t[];
    public int lengthOfLIS(int[] nums) {
        t = new int[nums.length];
        Arrays.fill(t, -1);
        int len = 1;
        int ans = 1;
        for(int i=0;i<nums.length;i++){
            len = Math.max(len, solve(nums, i));
        }

        return len;
    }

    public int solve(int nums[], int i){
        int maxLen = 1;
        if(i >= nums.length){
            return 0;
        }

        if(t[i] != -1){
            return t[i];
        }

        for(int j=i+1;j<nums.length;j++){
            if(nums[j] > nums[i]){
                maxLen = Math.max(maxLen, 1+solve(nums, j));
            }
        }

        t[i] = maxLen;
        return t[i];
    }
}
