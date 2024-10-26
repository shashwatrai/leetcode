class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0,r = nums.length -1;

        while(l<=r){
            int m = (l+r)/2;
            boolean left = m ==0 || (nums[m] > nums[m-1]);
            boolean right= m == nums.length-1 || (nums[m] > nums[m+1]);
            if(left & right){
                return m;
            }else if(left)
                l = m+1;
            else
                r = m-1;
        }
        return -1;
    }
}