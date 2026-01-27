class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
       // List<List<Integer>> adjList=new ArrayList<>();
        int V=rooms.size();
        boolean [] visited=new boolean[V];
        int start=0;
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.add(start);

        while(!q.isEmpty()){
            int curr=q.poll();
            

            for(int x:rooms.get(curr)){
                if(!visited[x]){
                    visited[x]=true;
                    q.add(x);
                }
            }
        }

        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
        
    }
}