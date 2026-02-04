import java.io.*;
import java.util.*;

public class buildingRoads {

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
            int c, sign = 1, val = 0;
            do {
                c = readByte();
            } while (c <= ' ');

            if (c == '-') {
                sign = -1;
                c = readByte();
            }

            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = readByte();
            }
            return val * sign;
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

        boolean[] visited = new boolean[n];
        ArrayList<Integer> sources = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, adj, visited);
                sources.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(sources.size() - 1).append('\n');

        for (int i = 0; i + 1 < sources.size(); i++) {
            sb.append(sources.get(i) + 1)
              .append(' ')
              .append(sources.get(i + 1) + 1)
              .append('\n');
        }

        System.out.print(sb.toString());
    }

    static void bfs(int src, ArrayList<Integer>[] adj, boolean[] visited) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(src);
        visited[src] = true;

        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : adj[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    q.add(v);
                }
            }
        }
    }
}
