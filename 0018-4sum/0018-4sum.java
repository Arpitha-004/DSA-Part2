class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans =  new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(i>0 && nums[i]==nums[i-1])
                continue;
            for(int j=i+1;j<nums.length;j++){
                if(j>i+1 && nums[j]==nums[j-1])
                    continue;
                int k=j+1,l=nums.length-1;
                long sum;
                while(k<l){
                    sum = (long)nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum>(long)target){
                        l--;
                    }else if(sum<(long)target){
                        k++;
                    }else{
                        List<Integer> lst = Arrays.asList(nums[i],nums[j],nums[k],nums[l]);
                        ans.add(lst);
                        k++;
                        l--;
                        while(k<l && nums[k]==nums[k-1]){
                            k++;
                        }
                        while(k<l && nums[l]==nums[l+1]){
                            l--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}