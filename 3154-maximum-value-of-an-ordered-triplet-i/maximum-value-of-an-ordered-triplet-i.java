class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans =0L;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                for(int k = j+1;k<nums.length;k++){
                    ans = Math.max(ans, (long)((long)(nums[i]-nums[j])* (long)nums[k]));
                }
            }
        }
        return ans;
    }
}