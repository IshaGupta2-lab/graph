class Solution {
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        int [] indegree=new int[V];
        
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> result=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        
        
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];
            adj.get(from).add(to);
            indegree[to]++;
            
            // if(indegree[i]==0){
            //     q.add(i);
            // }
        }
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            result.add(curr);
            
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;
                
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        return result;
    }
    
}