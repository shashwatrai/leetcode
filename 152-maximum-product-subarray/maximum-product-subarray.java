class Solution {
    public int maxProduct(int[] nums) {
        int minTill=1 ,maxTill = 1;
        int ans = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            int temp = minTill;
            minTill = Math.min(nums[i], Math.min(minTill*nums[i],maxTill*nums[i]));
            maxTill = Math.max(nums[i], Math.max(temp*nums[i],maxTill*nums[i]));

            ans = Math.max(ans,maxTill);
        }
        return ans;
    }
}