class Solution {
    public int rob(int[] nums) {
        
        int ans = nums[0] ;
        int prev = nums[0];
        int pprev = 0;
        for(int i=1;i<nums.length;i++){
            ans = Math.max(pprev+nums[i] , prev);

            pprev = prev;
            prev = ans;
        }
        return ans;
    }
}