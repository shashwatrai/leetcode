class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
       return count(nums,right) - count(nums,left -1); 
    }

    public int count(int []arr,int r){
        int ans =0 ;
        int start =0 ;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= r){
                ans += (i-start +1);
            }else{
                start = i+1;
            }
        }
        return ans;
    }
}