class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int curSum=0;
        for(int i=0;i<k;i++){
            curSum+=nums[i];
        }
        int maxSum=curSum;
        for(int i=k;i<nums.length;i++){
            curSum=curSum-nums[i-k]+nums[i];
            if(curSum>maxSum){
                maxSum=curSum;
            }
        }
        return (double)maxSum/k;
    }
}