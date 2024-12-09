class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int arr[] = new int[n];
        for(int i=1;i<nums.length;i++){
            arr[i] += arr[i-1] + (((nums[i]^nums[i-1])&1) == 0?1:0); 
        }   
        boolean []ans = new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
            ans[i] = ((arr[queries[i][1]] - arr[queries[i][0]]) == 0);
        }
        return ans;
    }
}