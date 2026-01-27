class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashMap<String,List<String>> adj=new HashMap<>();
        HashMap<String,Integer> map=new HashMap<>();

        Map<String,Integer> indegree=new HashMap<>();
        List<String> result=new ArrayList<>();

        for(int i=0;i<recipes.length;i++){
            List<String> str = ingredients.get(i);
            for(String s:str){
                List<String> temp = adj.getOrDefault(s,new ArrayList<>());
                temp.add(recipes[i]);
                adj.put(s,temp);
            }
        }

        for(int i=0;i<recipes.length;i++){
            String recipe=recipes[i];
            List<String> in=ingredients.get(i);
            indegree.put(recipe,in.size());
        }
        System.out.println(adj);
        Queue<String> q=new LinkedList<>();
        for(int i=0;i<supplies.length;i++){
            q.add(supplies[i]);
        }
       
        while(!q.isEmpty()){
            String item=q.poll();
            if(!adj.containsKey(item)){
                continue;
            }
            for(String recipe:adj.get(item)){
                indegree.put(recipe,indegree.get(recipe)-1);
                if(indegree.get(recipe)==0){
                    result.add(recipe);
                    q.add(recipe);
                }
            }
        }
        return result;

    }
}