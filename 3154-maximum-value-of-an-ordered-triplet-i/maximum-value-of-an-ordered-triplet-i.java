class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int []arr = new int[n];
        int max = nums[0];
        for(int i=1;i<n;i++){
            arr[i] = Math.max(arr[i-1],max - nums[i]);
            max = Math.max(max,nums[i]);
        }
        long ans = 0L;

        for(int i=n-1;i> 0 ;i--){
            ans = Math.max((long)arr[i-1] * (long)nums[i],ans);
        }
        return ans;
    }
}