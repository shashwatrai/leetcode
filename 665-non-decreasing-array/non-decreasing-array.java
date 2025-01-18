class Solution {
    public boolean checkPossibility(int[] nums) {
        int count =0;
        boolean allowed = true;
        int prev = -1;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] > nums[i+1]){
                if(prev > nums[i+1]){
                    if(!allowed)
                        return false;
                    allowed=false;
                    nums[i+1] = nums[i];
                    prev = nums[i];
                }else {
                    if(!allowed)
                        return false;
                    allowed = false;
                    prev = nums[i+1];
                }
            }else{
                prev = nums[i];
            }
        }
        return true;
    }
}