class Solution {
    public int subsetXORSum(int[] nums) {
        int ans=0;
        int n = 1 << nums.length;
        for(int i=0;i<n;i++){
            int temp =0;
            int j = i;
            int indx =0;
            while(j > 0){
                if((j&1) == 1){
                    temp ^= nums[indx];
                }
                indx++;
                j>>=1;
            }
            ans += temp;
        }
        return ans;
    }
}

