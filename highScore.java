import java.util.*;

public class highScore {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[m][3];
        for(int i = 0; i < m; i++){
            graph[i][0] = sc.nextInt() - 1;
            graph[i][1] = sc.nextInt() - 1;
            graph[i][2] = sc.nextInt();
        }

        ArrayList<ArrayList<Integer>> rev = new ArrayList<>();
        for(int i = 0; i < n; i++) rev.add(new ArrayList<>());

        for(int i = 0; i < m; i++){
            int from = graph[i][1];
            int to = graph[i][0];
            rev.get(from).add(to);
        }

        boolean[] canReach = new boolean[n];
        Stack<Integer> st = new Stack<>();
        st.push(n - 1);
        canReach[n - 1] = true;

        while(!st.isEmpty()){
            int curr = st.pop();
            for(int i = 0; i < rev.get(curr).size(); i++){
                int next = rev.get(curr).get(i);
                if(!canReach[next]){
                    canReach[next] = true;
                    st.push(next);
                }
            }
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MIN_VALUE);
        dist[0] = 0;

        for(int i = 0; i < n - 1; i++){
            for(int j = 0; j < m; j++){
                int u = graph[j][0];
                int v = graph[j][1];
                int w = graph[j][2];

                if(dist[u] != Long.MIN_VALUE && dist[v] < dist[u] + w){
                    dist[v] = dist[u] + w;
                }
            }
        }

        boolean flag = false;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                int u = graph[j][0];
                int v = graph[j][1];
                int w = graph[j][2];

                if(dist[u] != Long.MIN_VALUE && dist[v] < dist[u] + w){
                    dist[v] = dist[u] + w;
                    if(canReach[v]) flag = true;  
                }
            }
        }

        if(flag){
            System.out.println(-1);
        } else {
            System.out.println(dist[n - 1]);
        }
    }
}