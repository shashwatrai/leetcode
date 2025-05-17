class Solution {
    public void sortColors(int[] nums) {
        int l = -1,r = nums.length;

        int indx = 0;
        while(indx < r){
            if(nums[indx] == 0){
                if(indx > l+1){
                    nums[++l] = 0;
                    nums[indx] = 1;
                }else{
                    ++l;
                }
                indx++;
            }else if(nums[indx] ==2 ){
                if(indx + 1 < r){
                    nums[indx] = nums[--r];
                    nums[r]= 2;
                }else{
                    r--;
                    indx++;
                }
            }else
                indx++;
        }
    }
}