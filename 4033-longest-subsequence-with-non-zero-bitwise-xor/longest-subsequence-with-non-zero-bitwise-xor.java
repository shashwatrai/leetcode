class Solution {
    public int longestSubsequence(int[] nums) {
        int a = 0;
        int n = nums.length;
        int last = 0;
        for(int i:nums){
            a ^= i;
            if(i!=0)
                last = i;
    
        }
        if(a == 0 ){
            if(last != 0)
                return n-1;
            else
                return 0;
        }
        return n;
            
    }
}