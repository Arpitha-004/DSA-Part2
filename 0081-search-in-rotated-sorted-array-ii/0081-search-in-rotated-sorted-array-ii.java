class Solution {
    public boolean search(int[] nums, int target) {
        int n=nums.length;
        int l=0,h=n-1;
        while(l<=h){
            int m = (l+h)/2;

            if(nums[m]==target)
                return true;
            
            if(nums[l]==nums[m] && nums[m]==nums[h]){
                l+=1;
                h-=1;
                continue;
            }
            //left is sorted
            if(nums[l]<=nums[m]){
                if(nums[l]<=target && nums[m]>=target){
                    h=m-1;
                }else{
                    l=m+1;
                }
            }else{  //right is sorted
                if(nums[m]<=target && nums[h]>=target){
                    l=m+1;
                }else{
                    h=m-1;
                }
            }
        }
        return false;
    }
}