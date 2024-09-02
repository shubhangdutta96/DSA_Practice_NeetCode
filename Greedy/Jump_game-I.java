class Solution {
    public boolean canJump(int[] nums) {
        int farthest = 0;
        int currentEnd = 0;

        for(int i=0; i<nums.length-1; i++){
            farthest = Math.max(farthest, i + nums[i]);

            if(i == currentEnd){
                if(currentEnd == farthest){
                    return false;
                }
                currentEnd = farthest;
            }
            if(currentEnd >= nums.length-1){
                return true;
            }
        }

        return true;
    }
}
