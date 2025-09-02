class Solution {
    public int longestValidParentheses(String s) {
        int l=0,r=0,max=0;

        for(int i=0;i<s.length();i++){      //if 0->n then u may find more )
            if(s.charAt(i)=='(')
                l++;
            else
                r++;

            if(l==r){
                max=Math.max(max,l*2);
            }else if(r>l){
                l=0;
                r=0;
            }
        }
        l=0;r=0;
        for(int i=s.length()-1;i>=0;i--){      //if n->0 then u may find more (
            if(s.charAt(i)=='(')
                l++;
            else
                r++;

            if(l==r){
                max=Math.max(max,l*2);
            }else if(l>r){
                l=0;
                r=0;
            }
        }
        return max;
    }
}
