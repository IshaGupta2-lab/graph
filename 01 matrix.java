class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;

        int[][] result=new int[n][m];
        Queue<int[]> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.add(new int[]{i,j});
                    result[i][j]=0;
                } else{
                    result[i][j]=Integer.MAX_VALUE;
                }
            } 
        }
                int [][] dirs={{0,-1},{0,1},{1,0},{-1,0}};
                while(!q.isEmpty()){
                    int [] arr=q.poll();
                    int x=arr[0];
                    int y=arr[1];

                    for(int i=0;i<4;i++){
                        int nx=x+dirs[i][0];
                        int ny=y+dirs[i][1];

                        if(nx>=0 && nx<n && ny>=0 && ny<m){
                            if(result[nx][ny]> result[x][y]+1){
                                result[nx][ny]=result[x][y]+1;
                                q.add(new int[]{nx,ny});
                            }
                        }
                    }
                }
        return result;
    }
}