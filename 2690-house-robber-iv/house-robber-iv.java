class Solution {
    public boolean isPossible(int []nums,int target,int k){
        int len =0 ;
        for(int i=0;i<nums.length;i++){
            if(nums[i] <= target){
                len++;
                i++;
            }
        }
        return len >= k;
    }
    public int minCapability(int[] nums, int k) {
        int l = 1;
        int r = 1;
        for(int i:nums)
            r = Math.max(i,r);
        
        int ans = -1;
        while(l <= r){
            int mid = (l+r)/2;
            if(isPossible(nums,mid,k)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
        
    }
}