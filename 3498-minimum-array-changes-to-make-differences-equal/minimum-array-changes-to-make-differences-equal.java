class Solution {
    
    public int minChanges(int[] nums, int k) {
        int []arr = new int[k+2];
        int []arr2 = new int[k+2];
        int n  = nums.length;
        for(int i=0;i<n/2;i++){
            int j = n-1-i;
            int diff = Math.abs(nums[i] - nums[j]);
            int limit = Math.max( nums[i],Math.max(nums[j],Math.max(k - nums[i], k - nums[j])));
            arr[0]++;
            arr[limit+1]++;
            arr2[diff]--;
        }
        int  res = Integer.MAX_VALUE;
        for(int i=0;i<=k;i++){
            res = Math.min(res,arr[i]+arr2[i]);
            arr[i+1]+=arr[i];
        }
        return res;
    }
}