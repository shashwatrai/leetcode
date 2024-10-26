class Solution {
    public int majorityElement(int[] nums) {
        int cnt=0;
        int ele=-1;
        for(int i=0;i<nums.length;i++){
            if(cnt == 0){
                cnt = 1;
                ele = nums[i];
            }else if(ele == nums[i])
                cnt++;
            else
                cnt--;
        }
        cnt=0;
        for(int i:nums){
            if(ele == i)
                cnt++;
        }
        return cnt > nums.length/2? ele:-1;
    }
}