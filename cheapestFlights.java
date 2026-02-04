class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] graph = new ArrayList[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[] { 0, src, 0 });
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();

        }
        for (int[] f : flights) {
            int u = f[0];
            int v = f[1];
            int w = f[2];
            graph[u].add(new int[] { v, w });
        }
       
        int[][] dist = new int[n][k + 2];
        for (int[] d : dist) {
            Arrays.fill(d, Integer.MAX_VALUE);

        }
        dist[src][0] = 0;
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int cost = curr[0];
            int u = curr[1];
            int stops = curr[2];

            if (u == dst)
                return cost;
            if (stops > k)
                continue;

            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                int newT = cost + w;
                int newS = stops + 1;

                if (newT < dist[v][newS]) {
                    dist[v][newS] = newT;
                    pq.add(new int[] { newT, v, newS });
                }
            }
        }
        return -1;
    }
}