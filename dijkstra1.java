import java.util.*;
public class dijkstra1 {
    static class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            int w=sc.nextInt();
            adj.get(u).add(new Pair(v,w));
            adj.get(v).add(new Pair(u,w));
        }

        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.second-b.second);
        pq.add(new Pair(0,0));
        int src=0;
        dist[src]=0;
        int[] parent=new int[n];
        parent[src]=-1;
        boolean[] finalized=new boolean[n];
        


        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.first;
            int distance=curr.second;
            if(finalized[node]) continue; 
                  finalized[node]=true;

            for(Pair neigh:adj.get(node)){
                int v=neigh.first;
                int w=neigh.second;
                if(finalized[v]) continue; 
                  

                if(dist[v]>distance+w){
                    dist[v]=distance+w;
                    parent[v]=node;
                    pq.add(new Pair(v,dist[v]));
                }
            }
        }
        if(dist[n-1]==Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> path=new ArrayList<>();
        int curr=n-1;
        while(curr!=-1){
            path.add(curr+1);
            curr=parent[curr];
        }
        Collections.reverse(path);
        for(int x:path)
            System.out.print(x+" ");
        
        
        
        
    }
}