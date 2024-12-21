class Solution {
    public int maxValue(int[][] events, int k) {
        
        TreeMap<Integer, int[]> map = new TreeMap<>();

        Arrays.sort(events,(a,b) -> a[1] - b[1]);
        int ans = Integer.MIN_VALUE;
        for(int event[]: events){
            Integer prevnovlp = map.floorKey(event[0]-1);
            Integer prevovlp = map.floorKey(event[1]);
            if(!map.containsKey(event[1]))
                map.put(event[1],new int[k]);
            int []vals = map.get(event[1]);
            if(prevnovlp == null){
                if(prevovlp == null)
                    Arrays.fill(vals,event[2]);
                else{
                    int []prevVals = map.get(prevovlp);
                    vals[0] = Math.max(event[2],prevVals[0]);
                    for(int i=1;i<k;i++){
                        vals[i] = Math.max(vals[i-1],prevVals[i]);
                    }
                }
            }else{
                int []prevNoVals = map.get(prevnovlp);
                int []prevoVals = map.get(prevovlp);
                vals[0] = Math.max(event[2],Math.max(prevNoVals[0],prevoVals[0 ]));
                for(int i=1;i<k;i++){
                    vals[i] = Math.max(prevoVals[i],Math.max(
                         prevNoVals[i-1]+event[2], prevNoVals[i]));
                }
            }
            ans = Math.max(ans,vals[k-1]);
        }
        return ans;
    }
}