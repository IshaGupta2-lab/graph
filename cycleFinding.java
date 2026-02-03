import java.util.*;
public class cycleFinding {
    public static void main(String[] args){
        Scanner sc =new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int[][] graph=new int[m][3];
        long[] dist=new long[n];
        Arrays.fill(dist,0);
        int x=-1;
        int[] parent=new int[n];
        Arrays.fill(parent,-1);
        
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            int w=sc.nextInt();
            graph[i][0]=u;
            graph[i][1]=v;
            graph[i][2]=w;
        }
        for(int i=0;i<n;i++){
            x=-1;
            for(int [] edge:graph){
                int u=edge[0];
                int v=edge[1];
                int w=edge[2];

                
                if(dist[v]>dist[u]+w){
                    dist[v]=dist[u]+w;
                    parent[v]=u;
                    x=v;
                    
                }

            }
        }
        if(x==-1){
            System.out.println("NO");
            return;
        }
        for(int i=0;i<n;i++){
            x=parent[x];
        }
       
        ArrayList<Integer> cycle=new ArrayList<>();
        int curr=x;
        int start=x;
        
        
            System.out.println("YES");
            cycle.add(curr+1);
            curr=parent[curr];
            while(curr!=start){
               cycle.add(curr+1);
               curr=parent[curr];
            }
            cycle.add(start+1);
            Collections.reverse(cycle);
            for(int v:cycle){
                System.out.print(v+" ");
            }
            System.out.println();
        
        
    }
}


