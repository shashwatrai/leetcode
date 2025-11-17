class Solution {
    public long taskSchedulerII(int[] tasks, int space) {
        long ans = 0L;

        Map<Integer,Long> map = new HashMap<>();

        for(int i:tasks){
            ans = Math.max(map.getOrDefault(i,0L) , ans ) + 1L;    
            map.put(i,ans+(long)space);
        }
        return ans;
    }
}