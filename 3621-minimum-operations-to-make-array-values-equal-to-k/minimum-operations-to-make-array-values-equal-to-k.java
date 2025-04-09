class Solution {
    public int minOperations(int[] nums, int k) {
        boolean []arr = new boolean[101];
        int min = 1000;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(!arr[nums[i]])
                count++;
            min = Math.min(nums[i],min);
            arr[nums[i]] =true;
        }

        if(min < k)
            return -1;
        
        if(min == k)
            return count -1;
        
        return count;

    }
}