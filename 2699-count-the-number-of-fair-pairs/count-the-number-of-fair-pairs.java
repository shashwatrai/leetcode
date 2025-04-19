class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);

        int l = 0, r = 0;
        long cnt =0L;
        for(int i=nums.length-1;i>=0;i--){
            while(l < nums.length && nums[i] + nums[l] < lower){
                l++;
            }
            while(r < nums.length && nums[i]+nums[r] <= upper)
                r++;
            long sub = 0L;
            if(r > i && l <= i)
                sub = 1L;
            cnt += (long)(r-l) - sub;
        }
        return cnt/2;
    }
}