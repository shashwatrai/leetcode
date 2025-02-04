class Solution {
    public int maxAscendingSum(int[] nums) {
        int maxSum =nums[0];
        int temp = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] <= nums[i-1]){
                maxSum = Math.max(maxSum,temp);
                temp = 0;
            }
            temp += nums[i];
        }
        maxSum = Math.max(maxSum,temp);
        return maxSum;
    }
}