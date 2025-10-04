class Solution {
    public int maxArea(int[] height) {
        int ans =0 ;
        int n = height.length;
        int l = 0;
        int r = n-1;

        while(l<=r){
            ans = Math.max(ans, (r-l) * Math.min(height[l],height[r]));
            if(height[l] > height[r])
                r--;
            else
                l++;
        }
        return ans;
    }
}