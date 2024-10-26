class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1,ele1,cnt2,ele2;
        cnt1 = cnt2 = 0;
        ele1 = ele2 = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(cnt1 == 0 && ele2 != nums[i]){
                ele1 = nums[i];
            }else if(cnt2 == 0 && ele1 != nums[i]){
                ele2 = nums[i];
            }
            if(ele1 == nums[i]){
                cnt1++;
            }else if(ele2 == nums[i]){
                cnt2++;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        int r = nums.length/3;
        List<Integer> res = new ArrayList<>();
        cnt1=cnt2=0;
        for(int i:nums){
            if(i == ele1){
                cnt1++;
            }
            if(i == ele2)
                cnt2++;
        }
        if(cnt1 > r){
            res.add(ele1);
        }
        if(cnt2  > r){
            res.add(ele2);
        }
        return res;
        
    }
}