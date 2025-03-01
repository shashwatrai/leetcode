class Solution {
    public int[] applyOperations(int[] nums) {
        int j =0 ;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] *= 2;
                nums[i+1] = 0;
            }
            if(nums[i] != 0 ){
                if(j != i){
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
        if(nums[nums.length-1] != 0 && j != nums.length-1){

            nums[j] = nums[nums.length-1];
            nums[nums.length-1] = 0;
        }
        return nums;
    }
}