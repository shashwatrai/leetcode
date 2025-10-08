class Solution {
    public int maximizeGreatness(int[] nums) {
        TreeMap<Integer,Integer> tMap = new TreeMap<>();

        for(int i=0;i<nums.length;i++){
            tMap.put(nums[i],tMap.getOrDefault(nums[i],0)+1);
        }

        int ans =0;
        for(int i: nums){
            Integer d = tMap.ceilingKey(i+1);
            if(d == null)
                continue;
            
            if(tMap.get(d) == 1)
                tMap.remove(d);
            else
                tMap.put(d,tMap.get(d)-1);
            ans++;
        }
        return ans;

    }
}