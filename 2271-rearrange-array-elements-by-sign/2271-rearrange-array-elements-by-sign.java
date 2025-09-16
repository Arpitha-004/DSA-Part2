class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int pod=0,ned=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<0){
                ans[ned] = nums[i];
                ned+=2;
            }else{
                ans[pod] = nums[i];
                pod+=2;
            }
        }
        return ans;
    }
}