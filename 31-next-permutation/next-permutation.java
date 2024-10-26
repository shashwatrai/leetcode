class Solution {
    public void reverse(int []nums,  int l,int r){
        while(l<=r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
    }
    public void nextPermutation(int[] nums) {
        int indx = -1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i] < nums[i+1]){
                indx = i;
                break;
            }
        }
        if(indx == -1){
            reverse(nums,0,nums.length-1);
            return;
        }

        int l = indx+1,r = nums.length - 1;
        while(l<=r){
            int m = (l+r)/2;

            if(nums[m] > nums[indx])
                l = m+1;
            else
                r = m-1;
        }
        int temp = nums[indx];
        nums[indx] = nums[r];
        nums[r] = temp;

        reverse(nums,indx+1,nums.length-1);
    }
}