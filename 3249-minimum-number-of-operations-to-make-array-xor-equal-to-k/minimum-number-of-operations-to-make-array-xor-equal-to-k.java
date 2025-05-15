class Solution {
    public int minOperations(int[] nums, int k) {
        int res = 0;
        for(int i:nums)
            res ^= i;
        
        int ans=0;

        while(res > 0 || k > 0){
            if(res%2 != k%2)
                ans++;
            res /=2;
            k/=2;
        }
        return ans;
    }
}