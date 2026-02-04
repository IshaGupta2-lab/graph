// import java.util.*;
// public class buildingTeams {
//   public static void main(String[] args){
//     Scanner sc=new Scanner(System.in);
//     int n=sc.nextInt();
//     int m=sc.nextInt();
//     ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
//     for(int i=0;i<n;i++) adj.add(new ArrayList<>());
//     int[][] graph=new int[n][2];
//     for(int i=0;i<m;i++){
//         int u=sc.nextInt()-1;
//         int v=sc.nextInt()-1;
//         adj.get(u).add(v);
//         adj.get(v).add(u);
//     }
//     int[] team=new int[n];
//     boolean[] visited=new boolean[n];
//     for(int i=0;i<n;i++){
//         if(!visited[i]){
//             Queue<Integer> q=new LinkedList<>();
//             q.add(i);
//             team[i]=1;
//             visited[i]=true;

//             while(!q.isEmpty()){
//                 int curr=q.poll();
//                 for(int neigh:adj.get(curr)){
//                     if(!visited[neigh]){
//                         visited[neigh]=true;
//                         team[neigh]=1-team[curr];
//                         q.add(neigh);
//                     }
//                     else if(team[neigh]==team[curr]){
//                         System.out.println("IMPOSSIBLE");
//                         return;
//                     }
//                 }
//             }
//         }
//     }
//     for(int i=0;i<n;i++){
//         System.out.print((team[i]+1)+" ");
//     }
//   }  
// }

import java.io.*;
import java.util.*;

public class buildingTeams {

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int readByte() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val;
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        ArrayList<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt() - 1;
            int v = fs.nextInt() - 1;
            adj[u].add(v);
            adj[v].add(u);
        }

        int[] team = new int[n]; // 0 = unassigned, 1 or 2 = teams

        for (int i = 0; i < n; i++) {
            if (team[i] == 0) {
                ArrayDeque<Integer> q = new ArrayDeque<>();
                q.add(i);
                team[i] = 1;

                while (!q.isEmpty()) {
                    int curr = q.poll();
                    for (int neigh : adj[curr]) {
                        if (team[neigh] == 0) {
                            team[neigh] = 3 - team[curr];
                            q.add(neigh);
                        } else if (team[neigh] == team[curr]) {
                            System.out.println("IMPOSSIBLE");
                            return;
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(team[i]).append(' ');
        }
        System.out.print(sb.toString());
    }
}

