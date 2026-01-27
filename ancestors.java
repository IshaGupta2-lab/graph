class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        int [] indegree=new int[n];

        List<Set<Integer>> result=new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
            result.add(new HashSet<>());
        }
        for(int i=0;i<edges.length;i++){
              int from = edges[i][0];
              int to   = edges[i][1];
              adj.get(from).add(to);
              indegree[to]++;
        }

        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            //result.add(curr);

            for(int neigh:adj.get(curr)){
                result.get(neigh).add(curr);
                result.get(neigh).addAll(result.get(curr));
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> list=new ArrayList<>(result.get(i));
            Collections.sort(list);
            ans.add(list);
        }

        return ans;
    }
}