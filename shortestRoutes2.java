// import java.util.*;

// public class shortestRoutes2 {
//     public static void main(String[] args){
//         Scanner sc = new Scanner(System.in);

//         int n = sc.nextInt();
//         int m = sc.nextInt();
//         int q = sc.nextInt();

//         long[][] dist = new long[n+1][n+1];

//         for(int i = 1; i <= n; i++){
//             Arrays.fill(dist[i], Long.MAX_VALUE);
//             dist[i][i] = 0;
//         }

        
//         for(int i = 0; i < m; i++){
//             int a = sc.nextInt();
//             int b = sc.nextInt();
//             long c = sc.nextLong();

//             dist[a][b] = Math.min(dist[a][b], c);
//             dist[b][a] = Math.min(dist[b][a], c);
//         }

        
//         for(int k = 1; k <= n; k++){
//             for(int i = 1; i <= n; i++){
//                 for(int j = 1; j <= n; j++){
//                     if(dist[i][k] == Long.MAX_VALUE || dist[k][j] == Long.MAX_VALUE)
//                         continue;

//                     dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
//                 }
//             }
//         }

        
//         while(q-- > 0){
//             int a = sc.nextInt();
//             int b = sc.nextInt();

//             if(dist[a][b] == Long.MAX_VALUE){
//                 System.out.println(-1);
//             } else {
//                 System.out.println(dist[a][b]);
//             }
//         }
//     }
// }
import java.io.*;
import java.util.*;

public class shortestRoutes2 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        long INF = (long)1e18;
        long[][] dist = new long[n+1][n+1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if(c < dist[a][b]){
                dist[a][b] = c;
                dist[b][a] = c;
            }
        }

        // Floyd-Warshall optimized
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                if(dist[i][k] == INF) continue;

                for(int j = 1; j <= n; j++){
                    if(dist[k][j] == INF) continue;

                    long newDist = dist[i][k] + dist[k][j];
                    if(newDist < dist[i][j]){
                        dist[i][j] = newDist;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        while(q-- > 0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(dist[a][b] == INF) sb.append(-1).append('\n');
            else sb.append(dist[a][b]).append('\n');
        }

        System.out.print(sb);
    }
}