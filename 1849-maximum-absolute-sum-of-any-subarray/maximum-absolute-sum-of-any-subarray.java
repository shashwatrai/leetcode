class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        
        int min ,max;
        min  = max = nums[0];
        int ans = Math.abs(nums[0]);
        for(int i=1;i<n;i++){
            min = Math.min(nums[i],min + nums[i]);
            max = Math.max(nums[i],max + nums[i]);

            ans = Math.max(ans, Math.max(Math.abs(min),Math.abs(max)));
        }
        return ans;
    }
}