
class Solution {
    public int[] fullBloomFlowers(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,(a,b)-> a[1]!=b[1]?a[1]-b[1]:a[0]-b[0]);
        int max = intervals[intervals.length-1][1];
        
        TreeMap<Integer,Integer> tMap = new TreeMap<>();
        for(int i[]:intervals){
            tMap.put(i[0],tMap.getOrDefault(i[0],0)+1);
            tMap.put(i[1]+1,tMap.getOrDefault(i[1]+1,0)-1);
            
        } 
        List<Integer> arr = new ArrayList<>(tMap.keySet());
        for(int i=1;i<arr.size();i++){
            tMap.put(arr.get(i),tMap.get(arr.get(i))+tMap.get( arr.get(i-1)));
        }


        int ans[] = new int[queries.length];
        for(int i=0;i<ans.length;i++){
            Integer key = tMap.floorKey(queries[i]);
            if(key != null){
                ans[i] = tMap.get(key);
            }else
                ans[i] =0;
        }
        return ans;
    }
}

