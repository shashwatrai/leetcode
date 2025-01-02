class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int start ,end;
        start = -1;
        end =0;
        int n = nums.length;
        int ans=0;
        int prev=0;
        while(end < n){
            if(nums[end] >= left && nums[end] <= right){
                prev = end - start + prev;
                start = end;
                ans += prev; 
            }else if(nums[end] < left){
                ans += prev;
            }else{
                start = end ;
                prev = 0;
            }
            end++;
        }
        return ans;
    }
}
