// import java.util.*;
// class flightRoutes{
//    static ArrayList<Integer>[] adj,rev;
//    static boolean[] vis;
//    public static void dfs(int start,ArrayList<Integer>[]g){
//          Queue<Integer> q=new LinkedList<>();
//          q.add(start);
//         vis[start]=true;
//         while(!q.isEmpty()){
//              int u=q.poll();
//              for(int v:g[u]){
//                   if(!vis[v]){
//                        vis[v]=true;
//                        q.add(v);
//                   }
//              }
//         }
//    }
//    public static void main(String[] args){
//         Scanner sc=new Scanner(System.in);
//         int n=sc.nextInt();
//         int m=sc.nextInt();
//         adj=new ArrayList[n+1];
//         rev=new ArrayList[n+1];
//         for(int i=0;i<=n;i++){
//              adj[i]=new ArrayList<>();
//              rev[i]=new ArrayList<>();
//         }
//         for(int i=0;i<m;i++){
//              int u=sc.nextInt();
//              int v=sc.nextInt();
//              adj[u].add(v);
//              rev[v].add(u);
//         }
//         vis=new boolean[n+1];
//         dfs(1,adj);
//         for(int i=1;i<=n;i++){
//              if(!vis[i]){
//                   System.out.println("NO");
//                   System.out.println(1+" "+i);
//                   return;
//              }
//         }
//         vis=new boolean[n+1];
//         dfs(1,rev);
//          for(int i=1;i<=n;i++){
//              if(!vis[i]){
//                   System.out.println("NO");
//                   System.out.println(i+" "+1);
//                   return;
//              }
//          }
//          System.out.println("YES");
//    }
// }


import java.io.*;
import java.util.*;

class flightRoutesCheck {
    static ArrayList<Integer>[] adj, rev;
    static boolean[] vis;

    // Fast input reader
    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do {
                c = read();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }

    public static void bfs(int start, ArrayList<Integer>[] g) {
        Queue<Integer> q = new ArrayDeque<>();
        q.add(start);
        vis[start] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                if (!vis[v]) {
                    vis[v] = true;
                    q.add(v);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner();

        int n = fs.nextInt();
        int m = fs.nextInt();

        adj = new ArrayList[n + 1];
        rev = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            rev[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = fs.nextInt();
            int v = fs.nextInt();
            adj[u].add(v);
            rev[v].add(u);
        }

        vis = new boolean[n + 1];
        bfs(1, adj);
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                System.out.println("NO");
                System.out.println(1 + " " + i);
                return;
            }
        }

        vis = new boolean[n + 1];
        bfs(1, rev);
        for (int i = 1; i <= n; i++) {
            if (!vis[i]) {
                System.out.println("NO");
                System.out.println(i + " " + 1);
                return;
            }
        }

        System.out.println("YES");
    }
}
