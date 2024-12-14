class Solution {
    public long continuousSubarrays(int[] nums) {
        
        TreeMap<Integer,Integer> map = new TreeMap<>();

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int start ,end;
        start = end = 0;
        long ans = 0L;
        while(end < nums.length){
            min = Math.min(nums[end],min);
            max = Math.max(nums[end],max);
            map.put(nums[end],map.getOrDefault(nums[end],0)+1);
            
            while(max - min > 2){
                ans += (end - start);
                map.put(nums[start],map.getOrDefault(nums[start],0)-1);
                if(map.get(nums[start]) == 0)
                    map.remove(nums[start]);
           
                max = map.lastKey();
                min = map.firstKey();
                start++;
            }
            end++;
        }

        while(start < end){
            ans += (end - start);
            start++;
        }
        return ans;
    }   
}