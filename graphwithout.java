import java.util.*;
public class graphwithout {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] U=new int[m];
        int[] V=new int[m];
        for(int i=0;i<m;i++){
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            U[i]=u;
            V[i]=v;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color=new int[n];
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                Queue<Integer> q=new LinkedList<>();
                q.add(i);
                visited[i]=true;
                color[i]=0;
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int neigh:adj.get(curr)){
                        if(!visited[neigh]){
                            visited[neigh]=true;
                            color[neigh]=1-color[curr];
                            q.add(neigh);
                        }
                        else if(color[neigh]==color[curr]){
                            System.out.println("NO");
                            return ;
                        }
                    }
            }
        }

    }
    int[] ans=new int[m];
    for(int i=0;i<m;i++){
        int u=U[i];
        int v=V[i];
        if(color[u]< color[v]){
            ans[i]=0;
        }else{
            ans[i]=1;
        }
    }    
    System.out.println("YES");
    for(int val:ans){
        System.out.print(val);
    }
            
    
    
}
}
