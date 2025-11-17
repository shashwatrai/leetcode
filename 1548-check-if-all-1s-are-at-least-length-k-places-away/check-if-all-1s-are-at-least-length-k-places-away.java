class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        
        int start = 0;
        for(;start < nums.length && nums[start] == 0;start++);

        for(int i= start+1;i<nums.length;i++){
            if(nums[i] == 1){
                if( i - start - 1 < k)
                    return false;
                else
                    start = i;
            }
        }
        return true;
    }
}