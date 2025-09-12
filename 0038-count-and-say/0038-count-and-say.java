class Solution {
    public String countAndSay(int n) {
        String res = "1";
        for(int i=1;i<n;i++){
            int count=1;
            StringBuilder temp = new StringBuilder();
            for(int j=1;j<res.length();j++){
                if(res.charAt(j)!=res.charAt(j-1)){
                    temp.append(count).append(res.charAt(j-1));
                    count=1;
                }else{
                    count++;
                }
            }
            temp.append(count).append(res.charAt(res.length()-1)); //eg when n=2 to make it 11 in the next
            res = temp.toString();
        }
        return res;
    }
}