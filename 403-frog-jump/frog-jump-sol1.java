class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer,Set<Integer>> map = new HashMap<>();

        for(int i:stones){
            map.put(i, new HashSet<>());
        }
        map.get(stones[0]).add(0);

        for(int i=0;i<stones.length;i++){
            if(map.get(stones[i]).isEmpty())
                continue;
            for(int j: map.get(stones[i])){
                if(j > 1){
                    if(map.containsKey(stones[i] + j - 1)){
                        map.get(stones[i]+j-1).add(j-1); 
                    }
                }

                if(map.containsKey(stones[i] + j)){
                    map.get(stones[i]+j).add(j); 
                }

                if(map.containsKey(stones[i] + j + 1)){
                    map.get(stones[i]+j+1).add(j+1); 
                }
            }
        }
        return !map.get(stones[stones.length-1]).isEmpty();
    }
}
