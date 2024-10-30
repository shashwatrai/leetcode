class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String ,Set<String > > map = new HashMap<>();
        Map<String ,Integer> inDegree = new HashMap<>();
        Set<String> availableRecipes = new HashSet<>();
        for(int i=0;i<recipes.length;i++){
            inDegree.put(recipes[i],0);
            availableRecipes.add(recipes[i]);
            for(int j=0;j<ingredients.get(i).size();j++){
                if(!map.containsKey(ingredients.get(i).get(j))){
                    map.put(ingredients.get(i).get(j),new HashSet<>());
                }
                map.get(ingredients.get(i).get(j)).add(recipes[i]);
                inDegree.put(recipes[i],inDegree.get(recipes[i])+1);
            }
        }

        Queue<String> queue = new LinkedList<>();
        for(int i=0;i<supplies.length;i++){
            queue.add(supplies[i]);
        }

        List<String> ans = new ArrayList<>();

        while(!queue.isEmpty()){

            String node = queue.poll();
            if(availableRecipes.contains(node))
                ans.add(node);
            if(map.containsKey(node)){
                for(String j: map.get(node)){
                    inDegree.put(j,inDegree.getOrDefault(j,0)-1);
                    if(inDegree.get(j) == 0){
                        queue.add(j);
                    }
                }
            }
        }
        return ans;




    }
}