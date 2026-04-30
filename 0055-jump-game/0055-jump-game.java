class Solution {
    public boolean canJump(int[] nums) {
        int maxIn = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxIn)
                return false;

            maxIn = Math.max(maxIn,i+nums[i]);
        }
        return true;
    }
}