class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        int[] time=new int[n+1];
        Arrays.fill(time,Integer.MAX_VALUE);
        time[k]=0;
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<times.length;i++){
            int from=times[i][0];
            int to=times[i][1];
            int taken=times[i][2];
            adj.get(from).add(new int[]{to,taken});
        }
        pq.add(new int[]{k,0});
        boolean[] finalized = new boolean[n+1];

        while(!pq.isEmpty()){
            int[] node=pq.poll();
            int u=node[0];

            if(finalized[u]) continue;
            finalized[u]=true;

            for(int[] neigh:adj.get(u)){
                int v=neigh[0];
                int w=neigh[1];

                if(!finalized[v] && time[v]>(time[u]+w)){
                    time[v]=time[u]+w;
                    pq.add(new int[]{
                        v,time[v]
                    });
                }
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(time[i]==Integer.MAX_VALUE){
                return -1;
                
            }
            ans=Math.max(ans,time[i]);
        }
        return ans;

    }
}