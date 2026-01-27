// User function Template for Java

class Solution {

    int countDistinctIslands(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        
        Set<String> set=new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    List<String> shape=new ArrayList<>();
                    bfs(grid,i,j,shape);
                    set.add(String.join(",",shape));
                }
            }
        }
        return set.size();
             
        
        
    }
    public void bfs(int [][] grid,int baseR,int baseC,List<String> shape){
        int n=grid.length;
        int m=grid[0].length;
        
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{baseR,baseC});
        grid[baseR][baseC]=0;
        
        while(!q.isEmpty()){
            int[] curr=q.poll();
            
            int r=curr[0];
            int c=curr[1];
            
            shape.add((r-baseR)+ ":" +(c-baseC));
            int[][] dirs= {{0,-1},{0,1},{1,0},{-1,0}};
            
            for(int k=0;k<4;k++){
                int nx=r+dirs[k][0];
                int ny=c+dirs[k][1];
                
                if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                    grid[nx][ny]=0;
                    q.add(new int[]{nx,ny});
                }
            }
        }
    }
}    
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // Your Code here
//         int n=grid.length;
//         int m=grid[0].length;
        
//         Set<String> set=new HashSet<>();
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==1){
//                     List<String> shape=new ArrayList<>();
//                     dfs(grid,i,j,i,j,shape);
//                     set.add(String.join(",",shape));
//                 }
//             }
//         }
//         return set.size();
        
//     }
//     public void dfs(int[][] grid,int r,int c,int baseR,int baseC,List<String> shape){
//         int n=grid.length;
//         int m=grid[0].length;
        
//         if(r<0 || r>=n || c<0 || c>=m || grid[r][c]==0){
//             return;
//         }
//         grid[r][c]=0;
//         shape.add((r-baseR)+":"+(c-baseC));
        
//         dfs(grid,r+1,c,baseR,baseC,shape);
//         dfs(grid,r-1,c,baseR,baseC,shape);
//         dfs(grid,r,c+1,baseR,baseC,shape);
//         dfs(grid,r,c-1,baseR,baseC,shape);
//     }
// }
