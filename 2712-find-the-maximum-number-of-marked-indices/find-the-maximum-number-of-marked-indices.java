class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        int ans =0;

        int l = 0, r = (nums.length+1)/2;

        while(r < nums.length){
            if(nums[l] * 2 <= nums[r]){
                l++;
                ans+=2;
            }
            r++;
        }
        return ans;
    }
}