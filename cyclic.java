
import java.util.*;

public class cyclic{
  public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n=sc.nextInt();
    int m=sc.nextInt();

    ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    for(int i=0;i<n;i++){
        adj.add(new ArrayList<>());
    }
    for(int i=0;i<m;i++){
        int u=sc.nextInt()-1;
        int v=sc.nextInt()-1;
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
    boolean[] visited=new boolean[n];
    int count=0;
    for(int i=0;i<n;i++){
        if(!visited[i]){
            if(isCyclic(i,adj,visited)){
                count++;
            }
        }
    }
    System.out.println(count);
 }
 public static boolean isCyclic(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
    Queue<Integer> q=new LinkedList<>();
    q.add(node);
    visited[node]=true;
    boolean flag=true;
    
    while(!q.isEmpty()){
        int curr=q.poll();

        if(adj.get(curr).size()!=2){
            flag=false;
        }
       
        for(int neigh:adj.get(curr)){
            
            if(!visited[neigh]){
                visited[neigh]=true;
                q.add(neigh);
            }
        }
    }
    return flag;
    
 }
} 