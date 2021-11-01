class Solution {
    public void solve(char[][] board) {
        int n=board.length, m=board[0].length;
        boolean[][] visited=new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(board[i][j]=='O'){
                        dfs(board, visited, i, j);
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i!=0 && j!=0 && i!=n-1 && j!=m-1 && board[i][j]=='O' && !visited[i][j]){
                    board[i][j]='X';
                }
            }
        }

    }

    public void dfs(char[][] board, boolean[][] visited, int x, int y){
        if(x<0 || y<0 || x>=board.length || y>=board[0].length || visited[x][y] || board[x][y]=='X'){
            return;
        }

        visited[x][y]=true;
        int[][] dir={{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for(int i=0;i<4;i++){
            int X=x+dir[i][0];
            int Y=y+dir[i][1];
            if(X>=0 && Y>=0 && X<board.length && Y<board[0].length &&
              board[X][Y]=='O'){
                dfs(board, visited, X, Y);
            }
        }
    }
}