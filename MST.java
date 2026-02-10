class Solution {
    public int spanningTree(int V, int[][] edges) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        boolean[] visited=new boolean[V];
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        int ans=0;
        //int src=0;
    
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            int weigh=edges[i][2];
            adj.get(from).add(new int[]{to,weigh});
            adj.get(to).add(new int[]{from,weigh});
            
        }
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int w=curr[0];
            int v=curr[1];
            if(visited[v]) continue;
            visited[v]=true;
            ans+=w;
           
            for(int []neigh:adj.get(v)){
                int vt=neigh[0];
                int wt=neigh[1];
                if(!visited[vt]){
                    
                    pq.offer(new int[]{wt,vt});
                }
            }
        }
        return ans;
        
        
    }
}
