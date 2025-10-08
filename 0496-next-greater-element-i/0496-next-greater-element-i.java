class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>(); 
        int n = nums1.length, m = nums2.length;
        int[] nge = new int[10001];

        for(int i=m-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[nums2[i]]=-1;
            }else{
                nge[nums2[i]]=st.peek();
            }
            st.push(nums2[i]);
        }

        for(int i=0;i<n;i++){
            nums1[i] = nge[nums1[i]];
        }
        return nums1;
    }
}