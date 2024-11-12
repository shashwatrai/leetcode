class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b)-> a[0] - b[0]);
        TreeMap<Integer,Integer> tMap = new TreeMap<>();
        int maxTill = -1;
        for(int i[]:items){
            maxTill = Math.max(maxTill,i[1]);
            tMap.put(i[0],maxTill);
        }

        int n = queries.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            ans[i] = tMap.floorKey(queries[i]) == null ? 0 : tMap.get(tMap.floorKey(queries[i]));
        }
        return ans;
    }
}