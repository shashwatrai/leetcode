class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<int[]> arr = new ArrayList<>();

        for(int i=0;i<startTime.length;i++){
            arr.add(new int[]{startTime[i],endTime[i],profit[i]});
        }

        Collections.sort(arr,(a,b) -> a[1] != b[1] ? a[1] - b[1] : a[0] - b[0]);

        TreeMap<Integer,Integer> map  = new TreeMap<>();
        int ans =0;
        for(int i=0;i<arr.size();i++){
            Integer lastCompleted = map.floorKey(arr.get(i)[0]);
            int lastCompletedVal  = 0;
            if(lastCompleted != null)
                lastCompletedVal = map.get(lastCompleted);
            Integer overlappingCompleted = map.floorKey(arr.get(i)[1]);
            int overlappingCompletedVal =0;
            if(overlappingCompleted != null)
                overlappingCompletedVal = map.get(overlappingCompleted);

            ans = Math.max(lastCompletedVal+arr.get(i)[2],overlappingCompletedVal);

            map.put(arr.get(i)[1],Math.max(map.getOrDefault(arr.get(i)[1],0),ans));
        }
        return ans;
    }
}