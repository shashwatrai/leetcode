class Solution {
    public int longestSubarray(int[] nums) {
        int max = nums[0];
        for(int i=1;i<nums.length;i++)
            max = Math.max(nums[i],max);
        
        int len =1;
        int temp = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i] == max){
                temp++;
            }else{
                len = Math.max(temp,len);
                temp = 0;
            }
        }
        len = Math.max(temp,len);
        return len;
    }
}