class Solution {
    public void sortColors(int[] nums) {
        int z=-1;
        int t=nums.length;

        for(int i=0;i<t;i++){
            if(nums[i] == 0){
                nums[i] = nums[++z];
                nums[z] = 0;
            }else if(nums[i] == 2){
                nums[i] = nums[--t];
                nums[t] = 2;
                i--;
            }
        }
    }
}