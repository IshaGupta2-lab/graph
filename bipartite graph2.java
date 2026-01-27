class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int [] color=new int[V];
        boolean[] visited=new boolean[V];
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                visited[i]=true;
                color[i]=0;
                
                
                
                while(!q.isEmpty()){
                    int curr=q.poll();
                    
                    for(int x:adj.get(curr)){
                        if(!visited[x]){
                            visited[x]=true;
                            color[x]=1-color[curr];
                            q.add(x);
                        }
                        else if(color[x]==color[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}