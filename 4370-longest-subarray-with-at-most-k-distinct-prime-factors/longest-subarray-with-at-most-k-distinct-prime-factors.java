class Solution {
    public int[] buildSpf(int n) {
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            spf[i] = i;
        }

        for (int p = 2; p * p <= n; p++) {
            if (spf[p] == p) {
                for (int i = p * p; i <= n; i += p) {
                    spf[i] = p;
                }
            }
        }

        return spf;
    }
    public Map<Integer,Integer> factors(int n,int []spf){
        
        Map<Integer, Integer> ans = new HashMap<>();
        if(n == 1)
            return ans;
        while(n > 1){
            int p = spf[n];
            int count = 0;
            while(n%p == 0){
                n/=p;
                count++;
            }
            ans.put(p,count);
        }
        return ans;
    }
    public int longestSubarray(int[] nums, int k) {
        int max =0;
        for(int i:nums)
            max = Math.max(i, max);

        int []spf  = buildSpf(max);

        int start = 0, end = 0;
        int ans = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        while(end < nums.length){

            Map<Integer,Integer> right = factors(nums[end],spf);

            for(int key: right.keySet()){
                freq.put(key, right.get(key) + freq.getOrDefault(key,0));
            }

            while(freq.size() > k && start <= end){
                Map<Integer,Integer> startFactors = factors(nums[start],spf);
                for(int key: startFactors.keySet()){
                    freq.put(key, freq.get(key)-startFactors.get(key));
                    if(freq.get(key) == 0)
                            freq.remove(key);
                }
                start++;
            }
            ans = Math.max(end - start + 1,ans);
            end++;
        }
        return ans;
    }
}