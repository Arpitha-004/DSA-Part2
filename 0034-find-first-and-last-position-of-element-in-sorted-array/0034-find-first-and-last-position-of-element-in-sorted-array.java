class Solution {
    public int firstO(int[] nums, int k){
        int first = -1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==k){
                high=mid-1;
                first=mid;
            }
            else if(nums[mid]<k)
                low=mid+1;
            else
                high=mid-1;
        }
        return first;
    }
    public int lastO(int[] nums, int k){
        int last = -1;
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid]==k){
                low=mid+1;
                last=mid;
            }
            else if(nums[mid]<k)
                low=mid+1;
            else
                high=mid-1;
        }
        return last;
    }
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length;
        int a = firstO(nums,target);
        if(a==-1)
            return new int[]{-1,-1};

        int b = lastO(nums,target);
        return new int[]{a,b};
    }
}