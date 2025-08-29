class Solution {
    public boolean isHappy(int n) {
        int slow=n,fast=n;
        do{
            slow = sqdig(slow);
            fast = sqdig(sqdig(fast));
        }while(slow!=fast);
        return slow==1;
    }
    public int sqdig(int n){
        int sum=0;
            while(n!=0){
                sum+=Math.pow(n%10,2);
                n=n/10;
            }
        return sum;
    }
}