class Solution {
    public long[] resultArray(int[] nums, int k) {
        long []prev = new long[k];
        long []total = new long[k];
        for(int i=0;i<nums.length;i++){
            long []curr = new long[k];
            int r = nums[i]%k;
            curr[r]++;
            for(int j =0;j<k;j++){
                total[j] += prev[j];
                curr[(r*j)%k] += prev[j];
            }
            prev = curr;
        }
        for(int j=0;j<k;j++)
            total[j] += prev[j];
        return total;
        
    }
}