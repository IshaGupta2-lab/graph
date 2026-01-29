
import java.util.*;
public class Main {

    static int n,m;
    static int[] cat;
    static ArrayList<ArrayList<Integer>> adj;
    static boolean[] isVisited;
    static int count=0;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        cat = new int[n+1];
        for(int i = 1; i <= n; i++){
            cat[i] = sc.nextInt();
        }
        isVisited=new boolean[n+1];
        adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        dfs(1,0);
        System.out.println(count);
        
    }    
       
        public static void dfs(int node,int consecutiveCount){
            isVisited[node]=true;
            if(cat[node]==1){
                consecutiveCount++;
            }    
            else{
                consecutiveCount=0;
            }  
            if(consecutiveCount>m){

                return;
            }
            boolean isLeaf=true;    
            for(int neigh:adj.get(node)){
                if(!isVisited[neigh]){
                    isLeaf=false;
                    dfs(neigh,consecutiveCount);
                }
                else{
                    continue;
                }    
            }    
            if(isLeaf){
                 count++;
            }

            
        }
           
        

      
    

    
}