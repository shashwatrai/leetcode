class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        TreeMap<Integer,Integer> freq1 = new TreeMap<>();
        TreeMap<Integer,Integer> freq2 = new TreeMap<>();

        for(int i=0;i<nums.length;i++){
            freq1.put(nums[i],freq1.getOrDefault(nums[i],0)+1);

            freq2.put(nums[i]-k,freq2.getOrDefault(nums[i]-k,0)+1);
            freq2.put(nums[i]+k+1,freq2.getOrDefault(nums[i]+k+1,0)-1);

        }

        int sum =0 ;
        for(int i:freq2.keySet()){
            sum += freq2.get(i);
            freq2.put(i,sum);
        }

        int max  =0 ;
        // System.out.println(freq2);
        for(int i:freq2.keySet()){
            Integer ceiling = freq2.ceilingKey(i+1);

            if(ceiling == null)
                break;

            int t = freq2.get(i);
            max = Math.max(max, Math.min(t,numOperations));

            Integer l = freq1.ceilingKey(i);
            Integer r = freq1.floorKey(ceiling-1);
            // System.out.println(l+" "+r+" "+max+" "+i+" "+ceiling);
            while(l != null && r != null && l <= r){
                
                max = Math.max(max, freq1.get(l) + Math.min(t - freq1.get(l),numOperations));
                l = freq1.ceilingKey(l+1);
            }

        }

        return max;
    }
}