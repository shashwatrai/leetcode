class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, List<String>> adj = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        Set<String> setR = new HashSet<>();
        for(int i=0;i<recipes.length;i++){
            for(int j =0 ;j<ingredients.get(i).size();j++){
                if(!adj.containsKey(ingredients.get(i).get(j))){
                    adj.put(ingredients.get(i).get(j),new ArrayList<>());
                }
                adj.get(ingredients.get(i).get(j)).add(recipes[i]);
            }
            inDegree.put(recipes[i],ingredients.get(i).size());
            setR.add(recipes[i]);
        }

        List<String> ans = new ArrayList<>();

        Queue<String> queue = new LinkedList<>();
        for(String i: supplies){
            queue.add(i);
        }

        while(!queue.isEmpty()){
            String curr = queue.poll();
            if(setR.contains(curr))
                ans.add(curr);
            
            if(adj.containsKey(curr)){
                for(String j:adj.get(curr)){
                    inDegree.put(j,inDegree.get(j)-1);
                    if(inDegree.get(j) == 0)
                        queue.add(j);
                }
            }
        }
        return ans;
    }
}