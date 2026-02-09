class Solution {
    public int minTimeToReach(int[][] moveTime) {
       int n=moveTime.length;
       int m=moveTime[0].length;
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       int[][] dist=new int[n][m];
       for(int[] row:dist){
        Arrays.fill(row,Integer.MAX_VALUE);
       }
       dist[0][0]=0;
       pq.offer(new int[]{0,0,0});
       int[][]dirs={{0,-1},{0,1},{1,0},{-1,0}};
       while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int time=curr[0];
        int row=curr[1];
        int col=curr[2];

        if(time>dist[row][col]) continue;
        if(row==n-1 && col==m-1) return time;

        for(int k=0;k<4;k++){
            int nx=row+dirs[k][0];
            int ny=col+dirs[k][1];

            if(nx>=0 && nx<n && ny>=0 && ny<m){
                int next=Math.max(time,moveTime[nx][ny])+1;
                if(next<dist[nx][ny]){
                    dist[nx][ny]=next;
                    pq.offer(new int[]{next,nx,ny});
                }
            }
        }
       }
       return -1;
       
       }
}