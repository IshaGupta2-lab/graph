class Solution {
    class Pair {
        int node;
        int parent;

        Pair(int node, int parent) {
            this.node = node;
            this.parent = parent;
        }
    }

    public int findShortestCycle(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];

            adj.get(from).add(to);
            adj.get(to).add(from);
        }
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, bfs(adj, n, i));
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int bfs(ArrayList<ArrayList<Integer>> adj, int n, int start) {
        boolean[] isVis = new boolean[n];
        int[] dist = new int[n];

        Arrays.fill(dist, -1);
        Queue<Pair> q = new LinkedList<>();
        Pair p = new Pair(start, -1);
        q.add(p);
        isVis[start] = true;
        dist[start] = 0;

        int minCycle = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            Pair curr = q.poll();
            int currNode = curr.node;
            int parentNode = curr.parent;

            for (int neigh : adj.get(currNode)) {
                if (!isVis[neigh]) {
                    isVis[neigh] = true;
                    dist[neigh] = dist[currNode] + 1;
                    Pair temp = new Pair(neigh, currNode);
                    q.add(temp);
                } else {
                    if (isVis[neigh]) {
                        if (neigh != parentNode) {
                            minCycle = Math.min(minCycle, dist[currNode] + dist[neigh] + 1);
                        }
                    }
                }
            }
        }
        return minCycle;
    }
}