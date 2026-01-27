class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] d:dislikes){
            int u=d[0]-1;
            int v=d[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] likes=new int[n];
        boolean[] visited=new boolean[n];

        for(int i=0;i<n;i++){
            if(!visited[i]){
                Queue<Integer> q=new LinkedList<>();
                visited[i]=true;
                likes[i]=0;
                q.add(i);


                while(!q.isEmpty()){
                    int curr=q.poll();

                    for(int x:adj.get(curr)){
                        if(!visited[x]){
                            visited[x]=true;
                            likes[x]=1-likes[curr];
                            q.add(x);
                        }
                        else if(likes[x]==likes[curr]){
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}