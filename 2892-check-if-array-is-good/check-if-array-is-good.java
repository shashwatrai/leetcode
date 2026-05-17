class Solution {
    public boolean isGood(int[] nums) {
        int freq[] = new int[nums.length];

        for(int i=0;i<nums.length;i++){
            if(nums[i] >= nums.length )
                return false;
            freq[nums[i]]++;

            if(nums[i] != nums.length - 1 && freq[nums[i]] > 1)
                return false;
        }
        return freq[nums.length - 1] == 2;

    }
}