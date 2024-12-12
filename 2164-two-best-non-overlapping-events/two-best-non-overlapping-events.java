class Solution {
    public int maxTwoEvents(int[][] events) {
        Arrays.sort(events,(a,b)-> a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);

        TreeMap<Integer,Integer> map = new TreeMap<>();
        int ans=0;
        for(int event[]:events){
            Integer last = map.floorKey(event[0]-1);
            int prev = 0;
            if(last != null){
                prev = map.get(last);
            }
            

            Integer lastFilled = map.floorKey(event[1]);
            int lastFilledVal = 0;
            if(lastFilled != null){
                lastFilledVal = map.get(lastFilled);
            }
            ans = Math.max(ans,prev+event[2]);
            map.put(event[1], Math.max(lastFilledVal, event[2]));
        }
        return ans;
    }
}