class Pair{
    int row,col;
    Pair(int row,int col){
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public void bfs(int r,int c,int[][] vis,char[][] grid){
        Queue<Pair> q = new LinkedList<>();
        vis[r][c] = 1;
        q.add(new Pair(r,c));
        int n = grid.length;
        int m = grid[0].length;
        while(!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();
            int[] delRow = {-1, 0, 1, 0};
            int[] delCol = {0, 1, 0, -1};

            for(int k = 0; k < 4; k++) {
                int nrow = row + delRow[k];
                int ncol = col + delCol[k];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]=='1'){
                    vis[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
        
    }
    public int numIslands(char[][] grid) {
        int cnt=0;
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
    
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(vis[i][j]==0 && grid[i][j]=='1'){
                    bfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}