class Solution {
    public int countCommas(int n) {
        int ans = 0;

        int d = 1000;

        while(n >= d){
            ans += n - d + 1;
            d = d * 1000;
        }
        return ans;
    }
}