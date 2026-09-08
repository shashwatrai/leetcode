class Solution {
    public long countCommas(long n) {
        long ans = 0L;

        long d = 1000L;

        while(n >= d){
            ans += n - d + 1L;
            d = d * 1000L;
        }
        return ans;
    }
}