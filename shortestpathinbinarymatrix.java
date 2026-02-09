class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        int[][] dirs = {
        {0,1},{0,-1},{1,0},{-1,0},
        {1,1},{1,-1},{-1,1},{-1,-1}
        };

        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{0,0,1});
        grid[0][0]=1;

        while(!q.isEmpty()){
            int[] curr=q.poll();
            int r=curr[0];
            int c=curr[1];
            int d=curr[2];
            if(r==n-1 && c==n-1) return d;

            for(int k=0;k<8;k++){
                int nx=r+dirs[k][0];
                int ny=c+dirs[k][1];
                if(nx>=0 && nx<n && ny>=0 && ny<n && grid[nx][ny]==0){
                    grid[nx][ny]=1;
                    q.add(new int[]{nx,ny,d+1});
                }
            }
        }
        return -1;
    }
}