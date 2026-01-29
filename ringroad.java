import java.util.*;

public class  ringroad {

    static class Pair {
        int to, cost;
        Pair(int t, int c) {
            to = t;
            cost = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();


        ArrayList<Pair>[] adj = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }


        for (int i = 0; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj[u].add(new Pair(v, 0));  
            adj[v].add(new Pair(u, w));  
        }

    
        ArrayList<Integer> cycle = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];

        int start = 1;
        int prev = -1;
        int curr = start;

        while (true) {
            cycle.add(curr);
            visited[curr] = true;

            int next = -1;
            for (Pair e : adj[curr]) {
                if (e.to != prev) {
                    next = e.to;
                    break;
                }
            }

            if (next == start) break;

            prev = curr;
            curr = next;
        }

        
        long clockwise = 0;
        long anticlockwise = 0;

        for (int i = 0; i < cycle.size(); i++) {
            int u = cycle.get(i);
            int v = cycle.get((i + 1) % cycle.size());


            for (Pair e : adj[u]) {
                if (e.to == v) {
                    clockwise += e.cost;
                    break;
                }
            }

        
            for (Pair e : adj[v]) {
                if (e.to == u) {
                    anticlockwise += e.cost;
                    break;
                }
            }
        }

        System.out.println(Math.min(clockwise, anticlockwise));
    }
}
