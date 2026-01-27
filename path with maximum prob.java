class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq = new PriorityQueue<>((a, b) -> Double.compare(b[1], a[1]));
        double[] dist = new double[n];
        Arrays.fill(dist, Double.MIN_VALUE);
        dist[start_node] = 1.0;
        ArrayList<ArrayList<double[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            double prob = succProb[i];
            adj.get(from).add(new double[] { to, prob });
            adj.get(to).add(new double[] { from, prob });
        }
        pq.offer(new double[] { start_node, 1.0 });
        boolean[] finalized = new boolean[n];

        while (!pq.isEmpty()) {
            double[] node = pq.poll();
            int u = (int) node[0];

            if (finalized[u])
                continue;
            finalized[u] = true;
            for (double[] neigh : adj.get(u)) {
                int v = (int) neigh[0];
                double w = neigh[1];
                if (!finalized[v] && dist[v] < (dist[u] * w)) {
                    dist[v] = dist[u] * w;
                    pq.offer(new double[] { v, dist[v] });
                }
            }
        }
        return dist[end_node];
    }
}