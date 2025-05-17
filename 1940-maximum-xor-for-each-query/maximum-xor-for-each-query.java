class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int res = 0;
        for(int i:nums)
            res ^=i ;

        int ans[] = new int[nums.length];
        for(int indx=0;indx < ans.length;indx++){
            int temp=0;
            for(int i=0;i<maximumBit;i++){
                if((res & (1<<i)) == 0){
                    temp += (1<<i);
                }
            }
            ans[indx] = temp;
            res ^= nums[nums.length-1-indx];
        }
        return ans;
    }
}