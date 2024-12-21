class Solution {
    public int firstMissingPositive(int[] nums) {
        int i=0;
        while(i<nums.length){
            if(nums[i] > nums.length || nums[i] < 1){
                nums[i++] = 0;
            }else{
                if(i+1 == nums[i])
                    nums[i++]  = -1;
                else{
                    int temp = nums[i];
                    if(nums[i] == nums[temp-1] || (i+1 > nums[i] && nums[temp-1] == -1))
                        nums[i] =0;
                    else{
                        nums[i]  = nums[temp-1];

                        nums[temp-1] = temp;
                    }

                }
            }
        }
        for(i=0;i<nums.length;i++){
            if(nums[i] == 0)
                return i+1;
        }
        return nums.length+1;
    }
}