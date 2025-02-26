class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int n = nums.length;
        int arr[][] = new int[n][2];
        
        arr[0][0]= arr[0][1] = nums[0];
        int ans = Math.abs(nums[0]);
        for(int i=1;i<n;i++){
            arr[i][0] = Math.min(nums[i],arr[i-1][0] + nums[i]);
            arr[i][1] = Math.max(nums[i],arr[i-1][1] + nums[i]);

            ans = Math.max(ans, Math.max(Math.abs(arr[i][1]),Math.abs(arr[i][0])));
        }
        return ans;
    }
}