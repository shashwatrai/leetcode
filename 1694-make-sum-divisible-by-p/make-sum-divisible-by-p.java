class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum =0L;
        int n = nums.length;
        for(int i:nums){
            sum += (long)i;
        }
        
        int mod = (int)(sum%(long)p);
        System.out.println(sum +" "+mod);
        if(mod==0)
            return 0;
        
        
        Map<Integer,Integer> map = new HashMap<>();
        long temp =0L;
        int minLen = n;
        map.put(0, -1);
        for(int i=0;i<n;i++){
            temp += (long)nums[i];
            
            int newMod = (int)(temp%(long)p);
            System.out.print(newMod+" "+mod+" "+nums[i]);
            if(newMod != 0)
                minLen = Math.min(minLen,i-map.getOrDefault((p+newMod-mod)%p,i-n));
            if(newMod == mod){
                minLen= Math.min(minLen,i - map.get(0));
            }
            System.out.println(" "+minLen);
            map.put(newMod,i);
        }
        return minLen == n?-1:minLen;

    }
}