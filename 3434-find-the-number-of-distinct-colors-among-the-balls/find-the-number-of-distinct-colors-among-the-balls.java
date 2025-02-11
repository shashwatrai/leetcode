class Solution {
    public int[] queryResults(int limit, int[][] queries) {
        Map<Integer,Integer> color = new HashMap<>();

        Map<Integer,Set<Integer>> map = new HashMap<>();
        int []ans = new int[queries.length];
        int indx=0;
        for(int i[]:queries){
            if(color.containsKey( i[0])){
                map.get(color.get(i[0])).remove(i[0]);
                if(map.get(color.get(i[0])).isEmpty()){
                    map.remove(color.get(i[0]));
                }
            }
            color.put(i[0],i[1]);
            if(!map.containsKey(i[1]))
                map.put(i[1],new HashSet<>());
            map.get(i[1]).add(i[0]);
            ans[indx++] = map.size();
        }
        return ans;
    }
}