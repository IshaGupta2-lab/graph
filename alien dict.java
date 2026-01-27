class Solution {
    public String findOrder(String[] words) {
        // code here
        Map<Character,Integer> map=new HashMap<>();
        int count=0;
        
       // for(int i=0;i<words.length;i++){
            for(String word:words){
                for(char ch:word.toCharArray()){
                    if(map.containsKey(ch)){
                        continue;
                    }else{
                        map.put(ch,count);
                        count++;
                    }
                }
            }
            // System.out.println(map);
      //  }
        int[] indegree=new int[count];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        ArrayList<Integer> result=new ArrayList<>();
        Map<Integer, Character> reverseMap = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }
        
        for(int i=0;i<count;i++){
            adj.add(new ArrayList<>());
        }
        Queue<Integer> q=new LinkedList<>();
        boolean flag = false;
        for(int i=0;i<words.length-1;i++){
            String word1=words[i];
            String word2=words[i+1];
            int len=Math.min(word1.length(),word2.length());
            for(int j=0;j<len;j++){
                if(word1.charAt(j) != word2.charAt(j)){
                  int from=map.get(word1.charAt(j));
                  int to=map.get(word2.charAt(j));
                  adj.get(from).add(to);
                  indegree[
                      to]++;
                  flag = true;
                  break;
                //   System.out.println(Arrays.toString(indegree));
                }
            }
            if(! flag) {
                if(word1.length()>word2.length()){
                    return "";
                }
            }
        }
        
        //System.out.println(adj);
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        // System.out.println(Arrays.toString(indegree));
        while(!q.isEmpty()){
            int curr=q.poll();
            result.add(curr);
            
            for(int neigh:adj.get(curr)){
                indegree[neigh]--;
                
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        // System.out.println(result);
        int z = result.size();
        StringBuilder sb=new StringBuilder();
        if(z == count) {
           
            for(int x : result){
                sb.append(reverseMap.get(x));
                
            }
           // System.out.println(sb.toString());
            return sb.toString();
        }    
        return "";
    }
}