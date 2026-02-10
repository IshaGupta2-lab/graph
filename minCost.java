class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[] visited=new boolean[n];
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;
        int ans=0;
        for(int i=0;i<n;i++){
            int parent=-1;
            for(int j=0;j<n;j++){
                if(!visited[j] &&(parent==-1 || dist[j]<dist[parent])){
                    parent=j;

                }
            }
            visited[parent]=true;
            ans+=dist[parent];
            for(int v=0;v<n;v++){
                if(!visited[v]){
                    int cost=Math.abs(points[parent][0]-points[v][0])+Math.abs(points[parent][1]-points[v][1]);
                    dist[v]=Math.min(dist[v],cost);
                }
            }
        }
        return ans;
    }
}