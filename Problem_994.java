class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length, m=grid[0].length;
        int fresh=0, ans=0;
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.add(new int[]{i, j});
                    grid[i][j]=0;
                }else if(grid[i][j]==1){
                    ++fresh;
                }
            }
        }

        int[][] dir={{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int[] ar=q.poll();
                int X=ar[0], Y=ar[1];
                for(int i=0;i<4;i++){
                    int x=X+dir[i][0];
                    int y=Y+dir[i][1];
                    if(x>=0 && x<n && y>=0 && y<m && grid[x][y]==1){
                        --fresh;
                        grid[x][y]=0;
                        q.add(new int[]{x, y});
                    }
                }
            }
            if(q.size()>0)++ans;
        }

        if(fresh>0)return -1;
        return ans;
    }
}