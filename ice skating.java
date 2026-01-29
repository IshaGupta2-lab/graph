import java.util.*;

public class Main{
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] isVisited;

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] edges=new int[n][2];
        for(int i=0;i<n;i++){
            edges[i][0]=sc.nextInt();
            edges[i][1]=sc.nextInt();
        }
        adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(edges[i][0]==edges[j][0] || edges[i][1]==edges[j][1]){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        isVisited=new boolean[n];
        int components=0;

        for(int i=0;i<n;i++){
            if(!isVisited[i]){
                bfs(i);
                components++;
            }
        }
        System.out.println(components-1);
    }

    public static void bfs(int start){
        Queue<Integer> q=new LinkedList<>();
        q.add(start);
        isVisited[start]=true;

        while(!q.isEmpty()){
            int curr=q.poll();

            for(int neigh:adj.get(curr)){
                if(!isVisited[neigh]){
                    isVisited[neigh]=true;
                    q.add(neigh);
                }
            }
        }
    }
}