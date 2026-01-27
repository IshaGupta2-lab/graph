//bfs traversal



class Solution {
    public int orangesRotting(int[][] grid) {
       int n=grid.length;
       int m=grid[0].length;

       boolean [][] isVisited=new boolean[n][m];
       Queue<int[]> q=new LinkedList<>();

       int count=0;

       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                q.add(new int[]{i,j});
                isVisited[i][j]=true;
            }
            if(grid[i][j]==1) count++;
        }
       }


       int[][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
       int time=0;

       

       while(!q.isEmpty()){
        int len=q.size();
        boolean flag=false;
        for(int j=0;j<len;j++){
            int[] arr=q.poll();
            int x=arr[0];
            int y=arr[1];

            for(int i=0;i<4;i++){
                int nx=x+dirs[i][0];
                int ny=y+dirs[i][1];

                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1 && !isVisited[nx][ny]){
                    q.add(new int[]{nx,ny});
                    flag=true;
                    isVisited[nx][ny]=true;
                    count--;
                }
            }
        }
        if(flag==true) time++;
       } 
        if(count != 0) return -1;
       return time;
    }
    //return time;
}