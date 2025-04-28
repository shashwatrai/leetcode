class Solution {
    public long countSubarrays(int[] nums, long k) {
        int start = 0;
        int end = 0;
        int n = nums.length;
        long ans=0L;
        long sum =0L;
        while(end < n){
            sum += nums[end];
            // System.out.println(ans+" "+(long)((long)sum * (long)(end-start+1L)) +" "+ k);
            while((long)((long)sum * (long)(end-start+1L)) >= k){
                ans += (n-end);
                sum -= nums[start++];
            }

            end++;
        }
        while(start < n && (long)((long)sum * (long)(end-start)) >= k){
            ans += 1L;
            sum -= nums[start++];
        }
        return (long)((long)n*(long)(n+1))/2L-ans;

    }
}