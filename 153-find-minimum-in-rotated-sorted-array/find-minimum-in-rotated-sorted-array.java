class Solution {
    public int findMin(int[] nums) {
        int l = 0,r = nums.length-1;

        while(l<r-1){
            int m = (l+r)/2;

            if(nums[m] > nums[r] && nums[m] > nums[l]){
                l = m;
            }else{
                r = m;
            }
        }
        return Math.min(nums[l],nums[r]);
    }
}