import java.util.*;
class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int[]e:edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        int[] color=new int[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
               
                visited[i]=true;
                color[i]=0;
                q.add(i);
            }
            while(!q.isEmpty()){
                int curr=q.poll();
                for(int neigh:adj.get(curr)){
                    if(!visited[neigh]){
                        visited[neigh]=true;
                        color[neigh]=1-color[curr];
                        q.add(neigh);
                    }
                    else if(color[curr]== color[neigh]){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}