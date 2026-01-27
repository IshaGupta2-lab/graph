class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        
        int[] dist=new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        
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
        pq.offer(new int[]{src,0});
        boolean[] finalized=new boolean[V];
        
        while(!pq.isEmpty()){
            var node=pq.poll();
            int u = node[0];
            if(finalized[u]) continue; 
            finalized[u]=true;
            for(int[] neigh:adj.get(u)){
                int v=neigh[0];
                int w=neigh[1];
                if(!finalized[v] && dist[v]>(dist[u]+w)){
                    dist[v]=dist[u]+w;
                    pq.offer(new int[]{v,dist[v]});
                }
            }
        }
        return dist;
        
    }
}