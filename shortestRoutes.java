// import java.util.*;

// public class shortestRoutes {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int m = sc.nextInt();

//         ArrayList<ArrayList<long[]>> adj = new ArrayList<>();

//         for(int i = 0; i <= n; i++){
//             adj.add(new ArrayList<>());
//         }

//         for(int i = 0; i < m; i++){
//             int from = sc.nextInt();
//             int to = sc.nextInt();
//             long weight = sc.nextLong();
//             adj.get(from).add(new long[]{to, weight});
//         }

//         long[] dist = new long[n + 1];
//         Arrays.fill(dist, Long.MAX_VALUE);

//         PriorityQueue<long[]> pq = new PriorityQueue<>(
//             (a, b) -> Long.compare(a[1], b[1])
//         );

//         int src = 1;
//         dist[src] = 0;

//         pq.offer(new long[]{src, 0});

//         while(!pq.isEmpty()){
//             long[] node = pq.poll();
//             int u = (int) node[0];
//             long d = node[1];

//             if(d > dist[u]) continue;

//             for(long[] neigh : adj.get(u)){
//                 int v = (int) neigh[0];
//                 long w = neigh[1];

//                 if(dist[u] + w < dist[v]){
//                     dist[v] = dist[u] + w;
//                     pq.offer(new long[]{v, dist[v]});
//                 }
//             }
//         }

        
//         for(int i = 1; i <= n; i++){
//             System.out.print(dist[i] + " ");
//         }
//     }
// }
import java.io.*;
import java.util.*;

public class shortestRoutes {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<long[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            long w = Long.parseLong(st.nextToken());
            adj.get(from).add(new long[]{to, w});
        }

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        PriorityQueue<long[]> pq = new PriorityQueue<>(
            (a, b) -> Long.compare(a[1], b[1])
        );

        dist[1] = 0;
        pq.offer(new long[]{1, 0});

        while(!pq.isEmpty()){
            long[] cur = pq.poll();
            int u = (int) cur[0];
            long d = cur[1];

            if(d > dist[u]) continue;

            for(long[] edge : adj.get(u)){
                int v = (int) edge[0];
                long w = edge[1];

                if(dist[u] + w < dist[v]){
                    dist[v] = dist[u] + w;
                    pq.offer(new long[]{v, dist[v]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++){
            sb.append(dist[i]).append(" ");
        }

        System.out.println(sb);
    }
}