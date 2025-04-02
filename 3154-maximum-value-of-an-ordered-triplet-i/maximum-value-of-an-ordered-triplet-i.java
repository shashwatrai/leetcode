class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int []arr = new int[n];
        int max = nums[0];
        long ans = 0L;
        int prev = 0;
        for(int i=1;i<n;i++){
            ans = Math.max(ans,(long)prev*(long)nums[i]);
            int curr = Math.max(prev,max - nums[i]);
            max = Math.max(max,nums[i]);
            prev = curr;
        }
        return ans;
    }
}