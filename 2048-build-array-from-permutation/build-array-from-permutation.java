class Solution {
    public int[] buildArray(int[] nums) { 
        for(int i=0;i<nums.length;i++){
            if(nums[i] >= 0){
                int indx = i;
                int start = nums[indx];
                do{
                    int temp = nums[indx];
                    if(temp == i)
                        nums[indx] = -1 - start;
                    else
                        nums[indx] = -1 - nums[temp];
                    indx = temp;
                }while(indx != i);
            }
        }
        
        for(int i=0;i< nums.length;i++){
            nums[i] = -nums[i] - 1;
        }

        return nums;
    }
}

