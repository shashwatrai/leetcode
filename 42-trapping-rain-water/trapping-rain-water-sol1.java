class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int leftMax = height[left];
        int rightMax = height[right];
        int ans=0;
        while(left < right){
            if(height[left] < height[right]){
                ans += Math.min(leftMax,rightMax) - height[left];
                left++;
                leftMax = Math.max(leftMax,height[left]);
                
            }else{
                ans += Math.min(leftMax,rightMax) - height[right];
                right--;
                rightMax = Math.max(rightMax,height[right]);
                
                
            }
            
        }
        return ans;
    }
}
