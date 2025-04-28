class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        long p =1L;
        int start =0;
        int end=0;
        int n = nums.length;
        int ans=0;  
        while(end < n){
            p *= (long)nums[end];

            while(start <= end && p >= k){
                ans += n - end;
                p /= nums[start++];
            }   
            end++;
        }

        while(start < n && p >= k){
            ans += 1;
            p /= nums[start++];
        } 

        return (n*(n+1))/2 - ans;
    }
}