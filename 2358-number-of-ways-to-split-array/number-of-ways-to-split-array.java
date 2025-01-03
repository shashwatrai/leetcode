class Solution {
    public int waysToSplitArray(int[] nums) {
        int  n = nums.length;
        long prefix[] = new long[n];

        prefix[0] = nums[0];
        for(int i=1;i<n;i++){
            prefix[i] = (long)prefix[i-1] + (long)nums[i];
        }

        int ans=0;
        for(int i=0;i<n-1;i++){
            if(prefix[n-1] <= (long)2 * prefix[i] )
                ans++;
        }
        return ans;
    }
}