class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] hash = new int[26];
        Arrays.fill(hash,0);
        for(int i=0;i<n;i++){
            hash[s.charAt(i)-'a']++;
        }
        int maj=0,ele=0;
        for(int i=0;i<hash.length;i++){
            if(hash[i]>maj){
                maj=hash[i];
                ele=i;
            }
        }
        
        // IF majority > len/2 return empty, here (n+1)/2 is in case of odd len "aaabc" it return empty if n/2
        if(maj > (n+1)/2)
            return "";

        char[] res = new char[n];
        int idx=0;
        while(maj-->0){
            res[idx] = (char)(ele+'a');
            idx+=2;
        }

        hash[ele] = 0;
        // remaining filled in alphabetical order
        for(int i=0;i<hash.length;i++){
            while(hash[i]-->0){
                if(idx >= n){
                    idx=1;                          //if there is no more than one empty spaces
                }
                res[idx] = (char)(i+'a');
                idx+=2;
            }
        }
        return String.valueOf(res);
    }
}