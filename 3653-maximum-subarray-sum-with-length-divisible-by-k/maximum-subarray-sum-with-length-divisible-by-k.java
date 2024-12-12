class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        long []arr = new long[nums.length];
        arr[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            arr[i] = arr[i-1] + (long)nums[i];
        }

        long []res = new long[nums.length];
        long ans = Long.MIN_VALUE;
        for(int i=k-1;i<res.length;i++){
            res[i] = arr[i] - (i - k < 0 ? 0 :arr[i-k]);
            res[i] = Math.max(res[i] , res[i] + (i - k < 0 ? 0: res[i-k]));
            ans = Math.max(ans,res[i]);
        }
        return ans;
    }
}