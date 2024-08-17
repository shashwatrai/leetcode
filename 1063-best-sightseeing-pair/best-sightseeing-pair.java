class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        

        int max = 0;
        int dist = 1;
        max = values[0];
        int ans=0;
        for(int i=1;i<values.length;i++){
            ans = Math.max(ans, max+values[i] - dist);
            dist++;
            max = Math.max(max,values[i]+i);
        }
        return ans;
    }
}