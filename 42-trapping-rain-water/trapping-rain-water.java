class Solution {
    public int trap(int[] height) {
        int ans =0;
        int n = height.length;
        int lMax = height[0];
        int rMax = height[n-1];
        int l = 0,r = n-1;
        while(l<r){
            if(height[l] < height[r]){
                ans += lMax - height[l];
                l++;
                lMax = Math.max(lMax,height[l]);
            }else{
                ans += rMax - height[r];
                r--;
                rMax = Math.max(rMax,height[r]);
            }
        }
        return ans;
    }
}