class Solution {
    public boolean isHappy(int n) {
        int sum=0;
        Set<Integer> set = new HashSet<>();
        while(sum!=1 && !set.contains(sum)){
            set.add(sum);
            sum=0;
            while(n!=0){
                sum+=Math.pow(n%10,2);
                n=n/10;
            }
            n=sum;
        }
        return sum==1;
    }
}