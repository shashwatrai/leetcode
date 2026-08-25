class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int sum[] = new int[n];
        sum[0] = stones[0];
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] + stones[i];
        }

        int maxTillNow = sum[n-1];
        
        for(int i=n-2;i>0;i--){
            maxTillNow = Math.max(sum[i]-maxTillNow,maxTillNow);
        }
        return maxTillNow;
    }
}