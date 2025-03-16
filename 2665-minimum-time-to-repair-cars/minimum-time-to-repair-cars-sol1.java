class Solution {
    public boolean isPossible(int []ranks,int cars,long target){
        long sum=0L;

        for(int i:ranks){
            // System.out.println((double)((double)target/(double)i)+" "+(int)Math.sqrt((double)((double)target/(double)i)));
            sum += (long)Math.sqrt((double)((double)target/(double)i));
        }
        // System.out.println(sum+" "+cars);
        return sum >= (long)cars;
    }
    public long repairCars(int[] ranks, int cars) {
        long l = 0L,r = (long)1e14;


        while(l<=r){
            long m = (long)(l+r)/2L;
            
            if(isPossible(ranks,cars,m)){
                r = m-1L;
            }else{
                l = m+1L;
            }
        }
        return l;
    }
}
