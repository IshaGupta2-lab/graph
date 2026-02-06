class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            ans.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            int weight = edges[i][2];
            adj.get(from).add(new int[] { to, weight });
            adj.get(to).add(new int[] { from, weight });
        }

        for (int i = 0; i < n; i++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            Arrays.fill(dist, Integer.MAX_VALUE);
            Arrays.fill(visited, false);
            dist[i] = 0;
            pq.offer(new int[] { i, 0 });
            while (!pq.isEmpty()) {
                var node = pq.poll();
                int u = node[0];
                if (visited[u])
                    continue;
                visited[u] = true;
                for (int[] neigh : adj.get(u)) {
                    int v = neigh[0];
                    int w = neigh[1];
                    if (!visited[v] && dist[v] > (dist[u] + w)) {
                        dist[v] = dist[u] + w;
                        pq.offer(new int[] { v, dist[v] });
                    }
                }
            }
            for (int j = 0; j < n; j++) {
                if (distanceThreshold >= dist[j] && i != j) {
                    ans.get(i).add(j);
                }
            }
        }

        int city = 0;
        for (int i = 1; i < n; i++) {
            if (ans.get(i).size() <= ans.get(city).size()) {
                city = i;
            }
        }
        return city;

    }
}