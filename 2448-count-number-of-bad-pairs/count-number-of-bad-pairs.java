class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<n;i++){
            map.put(nums[i]-i,map.getOrDefault(nums[i]-i,0)+1);
        }

        long ans = (long)((long)(n-1)*(long)n)/2L;
        for(int i:map.keySet()){
            long t = map.get(i);

            ans -= (long)((long)(t-1)*(long)t) /2L;
        }
        return ans;
    }
}