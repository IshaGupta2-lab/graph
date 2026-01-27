class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
       int[] indegree=new int[numCourses];
       ArrayList<ArrayList<Integer>> adj=new ArrayList<>();

       ArrayList<Integer> result=new ArrayList<>();
       Queue<Integer> q=new LinkedList<>();
      // int[] indegree=new int[numCourses];

       for(int i=0;i<numCourses;i++){
        adj.add(new ArrayList<>());
       }
       for(int i=0;i<prerequisites.length;i++){
        int from=prerequisites[i][0];
        int to=prerequisites[i][1];
        adj.get(to).add(from);
        indegree[from]++;
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
       return((result.size())==numCourses);

    }
}