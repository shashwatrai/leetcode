class Solution {

    int primes[] = {2,3,5,7,11,13,17,19,23};

    public long find(int []coins, int state){
        List<Integer> arr = new ArrayList<>();

        for(int i=0;i<coins.length;i++){ 

            if((state & (1<<i)) != 0)
                arr.add(coins[i]);
        }

        List<Integer> lcm = new ArrayList<>();

        for(int i=0;i<primes.length;){
            boolean found = false;

            for(int j=0;j< arr.size();j++){
                if(arr.get(j) % primes[i] == 0){
                    found = true;
                    arr.set(j,arr.get(j)/primes[i]);
                }
            }
            if(found){
                lcm.add(primes[i]);
                continue;
            }
            i++;
        }

        long ans = 1L;
        for(int j:lcm)
            ans *= (long)j;
        return (long)ans;
    }
    public long findSign(int a){
        int count = 0;
        while(a > 0){
            if((a & 1) == 1)
                count++;
            a >>= 1;
        }
        return count%2 == 0 ? -1L : 1L;
    }
    public long findPos(Map<Long,Long> map, long m){
        long ans = 0L;

        for(long k : map.keySet()){
            ans +=  ((m/map.get(k)) * findSign((int)k));
        }
        // System.out.println(ans);
        return ans;
    }
    public long findKthSmallest(int[] coins, int k) {
        Map<Long,Long> map = new HashMap<>();
        long r = 0L, l = 30L;

        for(int i:coins){
            r = Math.max(i,r);
            l = Math.min(i,l);
        }
        r = r * (long)k;

        for(int i=1;i<(1 << coins.length);i++){
            map.put((long)i,find(coins,i));
        }   

        
        while(l <= r){

            long m = (l+r)/2L;
           
            long pos = findPos(map,m);
            // System.out.println(r+" "+l +" "+m+" "+pos);

            if(pos == (long)k)
                return prepareAns(coins , m);
            else if (pos < (long)k)
                l = m  +1;
            else
                r = m-1;
        }
        return 0L;
    }
    public long prepareAns(int []coins, long m){
        long ans = 0L;
        for(int i=0;i<coins.length;i++){
            long closest =  (m / (long)coins[i]) * (long)coins[i];
            ans = Math.max(ans,closest);
        }
        
        return ans;
    }
}