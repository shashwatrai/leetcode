class Solution {
    public int findMin(int[] nums) {
        int r = nums.length - 1;
        int l = 0;
        
        while(l < r && nums[r] == nums[l]){
            l++;
        }

        while(l < r - 1){
            int m = (l+r)/2;

            if(nums[m] >= nums[l] && nums[l] >= nums[r]){
                l = m;
            }else
                r = m;
        }

        return Math.min(nums[l],nums[r]); 
    }
}