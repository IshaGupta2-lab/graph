class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ans=0;
        int n=isConnected.length;

        boolean[] isVisited=new boolean[n];

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                bfs(isConnected,isVisited,i);
                ans++;
            }
        }
        return ans;
    }
    private void bfs(int[][] isConnected,boolean[] isVisited,int start){
        Queue<Integer> q=new LinkedList<>();

        q.add(start);

        isVisited[start]=true;
        while(!q.isEmpty()){
            int curr=q.remove();

            for(int i=0;i<isConnected.length;i++){
                if(isConnected[curr][i]==1 && !isVisited[i]){
                    isVisited[i]=true;
                    q.add(i);
                }
            }
        }
    }
}