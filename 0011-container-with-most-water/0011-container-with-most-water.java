class Solution {
    public int maxArea(int[] height) {
        int water=0,l=0,r=height.length-1;
        while(l<r){
            water = Math.max(water, Math.min(height[l],height[r])*(r-l));
            if(height[l]>=height[r]){
                r--;
            }else{
                l++;
            }
        }
        return water;
    }
}