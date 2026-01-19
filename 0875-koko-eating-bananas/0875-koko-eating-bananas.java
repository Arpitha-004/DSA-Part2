class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=Integer.MIN_VALUE;
        for(int i=0;i<piles.length;i++)
            high = Math.max(high,piles[i]);
        while(low<=high){
            int mid = (low+high)/2;
            int total = hours(piles,mid);
            if(total<=h){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return low;
    }
    public int hours(int[] piles,int m){
        double total = 0.0;
        for(int i=0;i<piles.length;i++){
            total+=Math.ceil((double)piles[i]/m);
        }
        return (int)total;
    }
}