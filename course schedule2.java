class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        int[] result=new int[numCourses];

        Queue<Integer> q=new LinkedList<>();

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
        int count=0;
        while(!q.isEmpty()){
            int curr=q.poll();
            result[count]=curr;
            count++;

            for(int neigh:adj.get(curr)){
               indegree[neigh]--;

               if(indegree[neigh]==0){
                q.add(neigh);
               }
            }
        }
        if(count!=numCourses) return new int[]{};
        return result;
    }
}