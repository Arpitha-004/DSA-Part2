class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int ini = image[sr][sc];
        dfs(image,sr,sc,ans,ini,color);
        return ans;
    }
    public void dfs(int[][] image,int row,int col,int[][] ans,int ini,int color){
        ans[row][col]=color;
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int n = image.length;
        int m = image[0].length;

        for(int i=0;i<4;i++){
            int nrow = row + dx[i];
            int ncol = col + dy[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==ini && ans[nrow][ncol]!=color){
                dfs(image,nrow,ncol,ans,ini,color);
            }
        }
    }
}