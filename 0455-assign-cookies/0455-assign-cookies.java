class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int j=0,i=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(j<s.length && i<g.length){
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
}