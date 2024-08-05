class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int ppp = 0;
        int pp = nums[0];
        int p = nums[1];
        int max  = Math.max(p,pp);
        for(int i= 2;i<nums.length-1;i++){
            max = Math.max(max,Math.max(p,nums[i] + Math.max(pp,ppp)));
            ppp = pp;
            pp = p;
            p = max;
        }
        if(nums.length== 2)
            return max;
        ppp = 0;
        pp = nums[1];
        p = nums[2];
        int max2 = Math.max(p,pp);
        for(int i= 3;i<nums.length;i++){
            max2 = Math.max(max2,Math.max(p,nums[i] + Math.max(pp,ppp)));
            ppp = pp;
            pp = p;
            p = max2;
        }
        return Math.max(max2,max);
    }
}