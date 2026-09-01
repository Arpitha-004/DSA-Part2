class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int res=0,sum=0;

        for(int i=0;i<k;i++){
            sum+=arr[i];
        }
        if(sum/k >= threshold){
            res++;
        }
        for(int i=k;i<arr.length;i++){
            sum-=arr[i-k];
            sum+=arr[i];
            if(sum/k >= threshold){
                res++;
            }
        }
        return res;
    }
}