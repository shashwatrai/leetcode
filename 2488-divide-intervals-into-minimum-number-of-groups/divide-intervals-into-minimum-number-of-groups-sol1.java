class Solution {
    public int minGroups(int[][] intervals) {
        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<intervals.length;i++){
            map.put(intervals[i][0],map.getOrDefault(intervals[i][0],0)+1);
            map.put(intervals[i][1]+1,map.getOrDefault(intervals[i][1]+1,0)-1);
        }
        int max =0;
        int curr=0;
        for(int i:map.keySet()){
            curr += map.get(i);
            max = Math.max(curr,max);
        }
        return max;
    }
}
