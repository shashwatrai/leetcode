class Solution {
    public int minimumIndex(List<Integer> nums) {
        int cnt =0;
        int num = -1;

        for(int i:nums){
            if(cnt == 0){
                cnt++;
                num = i;
            }else if(num == i){
                cnt++;
            }else
                cnt--;
        }
        int total = 0;
        for(int i:nums)
            if(i == num)
                total++;
            
        int indx = -1;
        cnt=0;
        // System.out.println(num);
        for(int i=0;i<nums.size();i++){
            if(nums.get(i) == num){
                cnt++;
            }
            if(2 * cnt > i + 1 && 2*(total-cnt) > nums.size() - i - 1)
                return i;
        }
        return -1;
    }
}