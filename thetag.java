import java.util.*;
import java.io.*;

public class thetag { 
    static ArrayList<ArrayList<Integer>> adj;
    static int[] distA;
    static int[] distB;
    static int n, x;

    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void bfs(int start, int[] dist) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        Arrays.fill(dist, -1);
        q.add(start);
        dist[start] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int neigh : adj.get(curr)) {
                if (dist[neigh] == -1) {
                    dist[neigh] = dist[curr] + 1;
                    q.add(neigh);
                }
            }
        }
    }

    public static void main(String[] args) {
        FastReader fr = new FastReader();
        
        n = fr.nextInt();
        x = fr.nextInt();
        
        adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n - 1; i++) {
            int from = fr.nextInt();
            int to = fr.nextInt();
            adj.get(from).add(to);
            adj.get(to).add(from);
        }

        distA = new int[n + 1];
        distB = new int[n + 1];

        bfs(1, distA);
        bfs(x, distB);

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (distB[i] < distA[i]) {
                max = Math.max(max, distA[i]);
            }
        }

        System.out.println(max * 2);
    }
}