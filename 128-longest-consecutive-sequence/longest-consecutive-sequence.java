class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> test = new HashSet<>();

        for(int i: nums){
            test.add(i);
        }

        int maxLen =0 ;

        for(int i=0;i<nums.length;i++){
            if(test.contains(nums[i]-1))
                continue;
            int len = 0;
            int a = nums[i];
            while(test.contains(a)){
                a++;
                len++;
            }
            maxLen = Math.max(maxLen,len);
        }
        return maxLen;
    }
}