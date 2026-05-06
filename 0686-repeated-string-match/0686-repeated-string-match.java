class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count=0;
        StringBuilder st = new StringBuilder();
        while(st.length()<b.length()){
            st.append(a);
            count++;
        }
        if(st.toString().contains(b)){
            return count;
        }
        if(st.append(a).toString().contains(b)){    // a=abcdabcd b=bcda
            return count+1;
        }
        return -1;
    }
}