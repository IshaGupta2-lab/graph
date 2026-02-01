import java.util.*;

public class bakery {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        
        if (k == 0) {
            System.out.println("-1");
            return;
        }

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] isBakery = new boolean[n + 1];
        int[] bakeries = new int[k];
        for (int i = 0; i < k; i++) {
            int city = sc.nextInt();
            isBakery[city] = true;
            bakeries[i] = city;
        }

        long ans = Long.MAX_VALUE;

        
        for (int i = 0; i < k; i++) {
            int u = bakeries[i];

            for (int[] edge : adj.get(u)) {
                int v = edge[0];
                int w = edge[1];

                
                if (!isBakery[v]) {
                    ans = Math.min(ans, (long)w);
                }
            }
        }

        System.out.println(ans == Long.MAX_VALUE ? -1 : ans);
    }
}