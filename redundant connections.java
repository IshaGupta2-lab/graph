class Solution {

    class Pair{
        int node;
        int parent;

        Pair(int node,int parent){
            this.node=node;
            this.parent=parent;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            int from=edges[i][0];
            int to=edges[i][1];

            boolean[] isVisited=new boolean[n+1];

            adj.get(from).add(to);
            adj.get(to).add(from);

            
                    if(dfs(adj,from,-1,isVisited))
                      
                         return new int[]{from,to};
                
            
        }
        return new int[0];
    }
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int start,int parent,boolean[] isVisited){
       
        isVisited[start]=true;

        for(int neigh:adj.get(start)){
            if(neigh==parent) continue;

            if(isVisited[neigh]) return true;

            if(dfs(adj,neigh,start,isVisited)){
                return true;
            }
        }
        return false;
    }
}