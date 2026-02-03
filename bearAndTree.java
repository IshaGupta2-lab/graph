import java.util.*;

public class bearAndTree {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int d = sc.nextInt();
        int h = sc.nextInt();

        
        if (d == 1 && n > 2) {
            System.out.println(-1);
            return;
        }

        if (d < h || d > 2 * h) {
            System.out.println(-1);
            return;
        }

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        int curr = 1;

        
        for (int i = 1; i <= h; i++) {
            adj.get(curr).add(curr + 1);
            adj.get(curr + 1).add(curr);
            curr++;
        }

        int Node;

        if (d > h) {
            Node = 1;
            for (int i = 1; i <= d - h; i++) {
                adj.get(Node).add(curr + 1);
                adj.get(curr + 1).add(Node);
                Node = curr + 1;
                curr++;
            }
            Node = 1;
        } else {
            Node = h;
        }

        while (curr < n) {
            adj.get(Node).add(curr + 1);
            adj.get(curr + 1).add(Node);
            curr++;
        }

        for (int i = 1; i <= n; i++) {
            for (int v : adj.get(i)) {
                if (i < v) {
                    System.out.println(i + " " + v);
                }
            }
        }
    }
}
