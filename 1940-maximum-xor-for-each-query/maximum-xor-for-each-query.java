class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int res = 0;
        for(int i:nums)
            res ^=i ;

        int ans[] = new int[nums.length];
        int temp = (1<<maximumBit) - 1;
        for(int indx=0;indx < ans.length;indx++){
            
            ans[indx] = res ^ temp;
            res ^= nums[nums.length-1-indx];
        }
        return ans;
    }
}