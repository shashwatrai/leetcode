class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        Integer minPQ = -1;
        Integer maxPQ = -1;
        long count=0;
        int start = -1;
        for(int i=0;i<nums.length;i++){


            if(nums[i] < minK || nums[i] > maxK){
               start = i;
            }

            if(nums[i] == minK)
                minPQ = i;
            if(nums[i] == maxK)
                maxPQ = i;
            
            count += Math.max(0,Math.min(maxPQ,minPQ)-start);
        }
        
        return count;
    }
}