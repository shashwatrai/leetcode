class Solution {
    int count;
    public void helper(int []nums,int indx,int curr,String s,int max){
        
        

        if(indx == nums.length){
            if(curr == max){
                count++;
            }
            return;
        }
        helper(nums,indx+1,curr,s,max);
        helper(nums,indx+1,curr|nums[indx],s+","+nums[indx],max);
    }

    public int countMaxOrSubsets(int[] nums) {
        count=0;
        int max = 0;
        for(int i:nums){
            max |= i;
        }
        helper(nums,0,0,"",max);
        return count;
    }
}