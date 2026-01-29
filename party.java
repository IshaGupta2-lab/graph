import java.util.*;
public class party{
    static int n;
    static int[][] edges;
    static ArrayList<ArrayList<Integer>> adj;
    static int[] indegree ;
    static int count;


    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        edges=new int[n][2];
        indegree=new int[n];
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            edges[i][0]=sc.nextInt();
            //edges[i][1]=sc.nextInt();
            if(edges[i][0]==-1 ){
                continue;
            }
            adj.get(edges[i][0]-1).add(i);
            indegree[i]++;
        }
        System.out.println(adj);
        Queue<Integer> q=new LinkedList<>();
        int[] level=new int[n];
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                //count+=1;
                q.add(i);
                level[i]=1;
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            count=Math.max(count,level[curr]);
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                    level[neigh]=level[curr]+1;
                }
            }
        }
        System.out.println(count);
        
    }
}