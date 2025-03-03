class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int arr[] = new int[n];

        int l = -1,r = n;

        for(int i=0;i<n;i++){
            if(nums[n-1-i] > pivot){
                arr[--r] = nums[n-i-1];
            }
            if(nums[i] < pivot){
                arr[++l] = nums[i];
            }
        }
        while(l < r - 1){
            arr[++l] = pivot;
        }
        return arr;
    }   
}