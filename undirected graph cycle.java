class Solution {
    class Pair{
        int node;
        int parent;
        
        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int start,int parent,boolean[] isVisited){
        isVisited[start]=true;
        
        for(int neigh:adj.get(start)){
            if(neigh==parent){
                continue;
            }
            if(isVisited[neigh]) return true;
            
    
                if(dfs(adj,neigh,start,isVisited))
                  return true;
            
            
        }
        return false;
    }
    // public boolean bfs(ArrayList<ArrayList<Integer>> adj,int start,boolean[] isVisited){
    //     Queue<Pair> q=new LinkedList<>();
       
       
    //     Pair p=new Pair(start,-1);
        
    //     q.add(p);
    //     isVisited[start]=true;
        
        
    //     while(!q.isEmpty()){
    //         Pair curr=q.poll();
    //         int currNode=curr.node;
    //         int parentNode=curr.parent;
            
            
    //         for(int neigh:adj.get(currNode)){
    //             if(neigh==parentNode) continue;
                 
                 
    //             else{
    //                 if(isVisited[neigh]) return true;
    //                 else{
    //                     isVisited[neigh]=true;
                        
    //                     Pair temp=new Pair(neigh,currNode);
    //                     q.add(temp);
    //                 }
    //             } 
    //         }
            
    //     }
    //     return false; 
        
        
        
    //}
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < V; i++)
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];
            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        
       // return bfs(adj, 0);
        
         boolean[] isVisited=new boolean[adj.size()];
         for(int i=0;i<isVisited.length;i++){
            if(!isVisited[i]){
                if(dfs(adj,i,-1,isVisited)) return true;
            }
         }
         return false;
        
    }
}