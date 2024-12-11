class Solution {
    public int maximumBeauty(int[] nums, int k) {
        
        int len = 0;
        for(int i=0;i<nums.length;i++){
            len = Math.max(nums[i],len);
        }
        int arr[] = new int[len+k+2];
        for(int i=0;i<nums.length;i++){
            int l = Math.max(0,nums[i]-k);
            int r = nums[i]+k;
            arr[l]++;
            arr[r+1]--;
        }
        int max =0;
        for(int i=1;i<arr.length;i++){
            arr[i] += arr[i-1];
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}