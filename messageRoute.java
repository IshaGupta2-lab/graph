// import java.util.*;
// public class messageRoute {
//     public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int m=sc.nextInt();

//         ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//         for(int i=0;i<=n;i++){   
//             adj.add(new ArrayList<>());
//         }

//         for(int i=0;i<m;i++){   
//             int from=sc.nextInt();
//             int to=sc.nextInt();
//             adj.get(from).add(to);
//             adj.get(to).add(from);
//         }

//         int src=1;
//         int dest=n;

//         Queue<Integer> q=new LinkedList<>();
//         q.add(src);

//         boolean[] visited=new boolean[n+1];
//         int[] parent=new int[n+1]; 

//         visited[src] = true;
//         parent[src] = -1;

//         while(!q.isEmpty()){
//             int node=q.poll();

//             if(node==dest){
                
//                 ArrayList<Integer> path=new ArrayList<>();
//                 int cur=dest;
//                 while(cur!=-1){
//                     path.add(cur);
//                     cur=parent[cur];
//                 }
//                 Collections.reverse(path);

//                 System.out.println(path.size());
//                 for(int x:path){
//                     System.out.print(x+" ");
//                 }
//                 return;
//             }

//             for(int neigh:adj.get(node)){
//                 if(!visited[neigh]){
//                     visited[neigh]=true;
//                     parent[neigh]=node;   
//                     q.add(neigh);
//                 }
//             }
//         }

//         System.out.println("IMPOSSIBLE");   
//     }
// }
import java.io.*;
import java.util.*;

public class messageRoute {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int from=Integer.parseInt(st.nextToken());
            int to=Integer.parseInt(st.nextToken());
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        int src=1;
        int dest=n;

        Queue<Integer> q=new LinkedList<>();
        q.add(src);

        boolean[] visited=new boolean[n+1];
        int[] parent=new int[n+1];

        visited[src] = true;
        parent[src] = -1;

        while(!q.isEmpty()){
            int node=q.poll();

            if(node==dest){
                ArrayList<Integer> path=new ArrayList<>();
                int cur=dest;
                while(cur!=-1){
                    path.add(cur);
                    cur=parent[cur];
                }
                Collections.reverse(path);

                StringBuilder sb=new StringBuilder();
                sb.append(path.size()).append("\n");
                for(int x:path){
                    sb.append(x).append(" ");
                }
                System.out.println(sb);
                return;
            }

            for(int neigh:adj.get(node)){
                if(!visited[neigh]){
                    visited[neigh]=true;
                    parent[neigh]=node;
                    q.add(neigh);
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}