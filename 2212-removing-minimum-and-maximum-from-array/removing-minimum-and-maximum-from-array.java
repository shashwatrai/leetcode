class Solution {
    public int minimumDeletions(int[] nums) {
        int idx1 ,idx2, max1, min1;

        idx1 = idx2 = 0;
        min1 = max1 = nums[0];

        for(int i=1;i<nums.length;i++){
            if(nums[i] > max1){
                idx1 = i;
                max1 = nums[i];
            }
            if(nums[i] < min1){
                idx2 = i;
                min1 = nums[i];
            }
        }
        System.out.println(idx1 +" "+idx2);
        int n = nums.length;
        return Math.min(Math.min(Math.max(idx1,idx2) + 1, n - Math.min(idx1,idx2)) , Math.min(idx1,idx2) + n - Math.max(idx2,idx1) + 1); 
    }
}