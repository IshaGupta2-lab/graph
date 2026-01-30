import java.util.*;
public class foxandnames {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] words=new String[n];
        for(int i=0;i<n;i++){
            words[i]=sc.next();
        }
        int[] indegree=new int[26];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<26;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            String w1=words[i];
            String w2=words[i+1];
            int len=Math.min(w1.length(),w2.length());
            boolean found=false;
            for(int j=0;j<len;j++){
                if(w1.charAt(j)!=w2.charAt(j)){
                    int from=w1.charAt(j)-'a';
                    int to=w2.charAt(j)-'a';
                     if(!adj.get(from).contains(to)) {
                        adj.get(from).add(to);
                        indegree[to]++;
                     }
                    
                    found=true;
                    break;
                }
            }
            if(!found && w1.length()>w2.length()){
                System.out.println("Impossible");
                return;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        StringBuilder result=new StringBuilder();
        while(!q.isEmpty()){
            int curr=q.poll();
            result.append((char)(curr+'a'));
            for(int v:adj.get(curr)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        if(result.length()!=26){
            System.out.println("Impossible");
        }else{
            System.out.println(result);
        }
    }
}