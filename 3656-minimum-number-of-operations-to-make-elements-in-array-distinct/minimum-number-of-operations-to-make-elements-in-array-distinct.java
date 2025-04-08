class Solution {
    public int minimumOperations(int[] nums) {
        int arr[] = new int[101];
        for(int i=nums.length-1;i>=0;i--){
            if(arr[nums[i]] > 0){
                return (int)Math.ceil((double)(i+1)/3);
            }
            arr[nums[i]] = 1; 
        }
        return 0;
    }
}