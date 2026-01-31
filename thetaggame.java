import java.util.*;
public class thetag {
    static ArrayList<ArrayList<Integer>> adj;
    static int[] distA;
    static int[] distB;
    static int n,x;

    public static void bfs(int start,int[] dist){
        ArrayDeque<Integer>q=new ArrayDeque<>();
        Arrays.fill(dist,-1);
        q.add(start);
        dist[start]=0;

        while(!q.isEmpty()){
            int curr=q.poll();
            for(int neigh:adj.get(curr)){
                if(dist[neigh]==-1){
                    dist[neigh]=dist[curr]+1;
                    q.add(neigh);
                }
            }
        }
        
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        x=sc.nextInt();
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int from=sc.nextInt();
            int to=sc.nextInt();
            adj.get(from).add(to);  
            adj.get(to).add(from);
        }
        distA=new int[n+1];
        distB=new int[n+1];

        bfs(1,distA);
        bfs(x,distB);
        int max=0;
        for(int i=1;i<=n;i++){
            if(distB[i]<distA[i]){
                max=Math.max(max,distA[i]);
            }
        }

        System.out.println(max*2);
        
    }
}
