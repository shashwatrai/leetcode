class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int temp =0;
        for(int i=0;i<nums.length;i++){
            temp = Math.max(temp+nums[i],nums[i]);
            maxSum = Math.max(maxSum,temp);
        }
        return maxSum;
    }
}