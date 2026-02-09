// import java.util.*;
// public class flightRoutes {
//    public static void main(String[] args){
//     Scanner sc=new Scanner(System.in);
//     int n=sc.nextInt();
//     int m=sc.nextInt();
//     int k=sc.nextInt();
//     @SuppressWarnings("unchecked")
//     ArrayList<int[]>[] adj = new ArrayList[n+1];

//     for(int i=0;i<=n;i++){
//         adj[i]=new ArrayList<>();
//     }
//     for(int i=0;i<m;i++){
//         int u=sc.nextInt();
//         int v=sc.nextInt();
//         int w=sc.nextInt();
//         adj[u].add(new int[]{v,w});
//     }
    
        
//     ArrayList<Long>[] best=new ArrayList[n+1];
//     for(int i=0;i<=n;i++){
//         best[i]=new ArrayList<>();
//     }
    
//     PriorityQueue<long[]> pq =
//             new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

//     pq.offer(new long[]{0,1});
//     while(!pq.isEmpty()){
//         long[] curr=pq.poll();
//         long cost=curr[0];
//         int node=(int)curr[1];

//         if(best[node].size()==k) continue;
//         best[node].add(cost);
//         for(int[] edge:adj[node]){
//             int v=edge[0];
//             long w=edge[1];
//             pq.offer(new long[]{cost+w,v});
//             }
//         }
//         for(long cost:best[n]){
//             System.out.print(cost+" ");
//         }

//    } 
// }
import java.io.*;
import java.util.*;

public class flightRoutes {

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

        long nextLong() throws IOException {
            long val = 0;
            int c;
            while ((c = read()) <= ' ') ;
            boolean neg = false;
            if (c == '-') {
                neg = true;
                c = read();
            }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return neg ? -val : val;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();

        int n = (int) fs.nextLong();
        int m = (int) fs.nextLong();
        int k = (int) fs.nextLong();

        ArrayList<int[]>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) adj[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = (int) fs.nextLong();
            int v = (int) fs.nextLong();
            int w = (int) fs.nextLong();
            adj[u].add(new int[]{v, w});
        }

        int[] cnt = new int[n + 1];

        PriorityQueue<long[]> pq =
                new PriorityQueue<>(Comparator.comparingLong(a -> a[0]));

        pq.add(new long[]{0, 1});

        StringBuilder out = new StringBuilder();

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long dist = cur[0];
            int u = (int) cur[1];

            if (cnt[u] == k) continue;
            cnt[u]++;

            if (u == n) {
                out.append(dist).append(' ');
                if (cnt[n] == k) break;
            }

            for (int[] e : adj[u]) {
                if (cnt[e[0]] < k) {
                    pq.add(new long[]{dist + e[1], e[0]});
                }
            }
        }

        System.out.print(out.toString());
    }
}
