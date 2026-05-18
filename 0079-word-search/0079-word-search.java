class Solution {
    boolean visited[][];
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(word.charAt(0)==board[i][j] && search(i,j,0,board,word)){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean search(int i,int j,int ind,char[][] board, String word){
        if(ind==word.length())
            return true;

        if(i<0 || i>=board.length || j<0 || j>=board[i].length || word.charAt(ind)!=board[i][j] || visited[i][j])
            return false;

        visited[i][j]=true;
        if(search(i+1,j,ind+1,board,word)||search(i-1,j,ind+1,board,word)||search(i,j+1,ind+1,board,word)||search(i,j-1,ind+1,board,word)){
            return true;
        }
        visited[i][j]=false;   
        return false;
    }
}