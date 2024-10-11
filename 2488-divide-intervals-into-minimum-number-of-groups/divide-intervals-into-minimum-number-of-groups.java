class Solution {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);

        TreeMap<Integer,Integer> map = new TreeMap<>();

        for(int i=0;i<n;i++){
            Integer curr = map.floorKey(intervals[i][0]-1);

            if(curr != null){
               map.put(curr,map.get(curr)-1);
               if(map.get(curr) == 0)
                    map.remove(curr);
            }
            map.put(intervals[i][1],map.getOrDefault(intervals[i][1],0)+1);
            // System.out.println(map);
        }
        int ans=0;
        for(int i:map.keySet()){
            ans += map.get(i);
        }
        return ans;
    }
}