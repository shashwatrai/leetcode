class Solution {
    public List<Long> traverse(Map<Integer,List<Integer> > map,boolean vis[], int[] values, int curr){
        vis[curr] = true;

        List<List<Long>> ans = new ArrayList<>();
        for(int i:map.get(curr)){
            if(!vis[i]){
                ans.add(traverse(map,vis,values,i));
            }
        }
        List<Long> finalAns = new ArrayList<>();
        if(ans.isEmpty()){
            finalAns.add(0L);
            finalAns.add((long)values[curr]);
            return finalAns;
        }
        long merged = 0L;
        for(List<Long> r : ans){
            merged += r.get(1);
        }
        if(merged > (long)values[curr]){
            for(List<Long> r : ans){
                merged += r.get(0);
            }
            
            finalAns.add(merged);
            finalAns.add((long)values[curr]);
            
        }else{
            long mergedScore = values[curr];
            for(List<Long> r : ans){
                mergedScore += r.get(0);
            }
            
            finalAns.add(mergedScore);
            finalAns.add(merged);
        }
        return finalAns;
    }
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        Map<Integer,List<Integer> > map = new HashMap<>();

        for(int i[]:edges){
            if(!map.containsKey(i[0]))
                map.put(i[0],new ArrayList<>());
            if(!map.containsKey(i[1]))
                map.put(i[1],new ArrayList<>());
            
            map.get(i[0]).add(i[1]);
            map.get(i[1]).add(i[0]);
        }

        boolean vis[] = new boolean[values.length];

        List<Long> res = traverse(map,vis,values,0);
        return res.get(0);
    }
}