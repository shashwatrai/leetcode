class Solution {
    public int subsetXORSum(int[] nums) {
        int r  =0 ;
        for(int i:nums){
            r |= i;
        }
        return r << (nums.length-1);
    }
}