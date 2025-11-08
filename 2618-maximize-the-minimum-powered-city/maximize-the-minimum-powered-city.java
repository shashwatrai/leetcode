class Solution {

    public boolean isPossible(int []stations, int r, long k , long limit){

        long left = 0L;
        long right = 0L;

        for(int i=0;i<r;i++)
            right = right + (long)stations[i];
        
        long p = 0L;
        long n = 0L;
        long []negation = new long[stations.length];

        long required = 0L;
        for(int i=0;i<stations.length;i++){

            n = n + negation[i];
            if(i-r-1 >= 0)
                left = left + (long)stations[i-r-1];


            if(i+r < stations.length)
                right = right + (long)stations[i+r];

            long diff = right - left + p + n ;
            
            if(diff < limit){
                required = required + limit - diff;
                p = p + limit - diff;
                if(i+2*r + 1 < stations.length)
                    negation[i+ 2*r + 1] = diff - limit;
            }
            if(required > k)
                return false;
            // if(limit == 5L)
                // System.out.println(right+" "+left+" "+i+" "+p+" "+n+ " "+(i+2*r));
        }
        return required <= k;
    }

    public long maxPower(int[] stations, int radius, int k) {
        
        long l = 1L;
        long r = (long)1e15;

        while(l <= r){
            long m = (l+r)/2L;
            // System.out.println(m +" "+isPossible(stations,radius,k,m));
            if(isPossible(stations,radius,k,m))
                l = m+1L;
            else
                r = m - 1L;
        }
        return r;
    }
}