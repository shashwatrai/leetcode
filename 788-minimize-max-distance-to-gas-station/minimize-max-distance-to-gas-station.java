class Solution {
    public boolean isPossible(int []stations,double m,int k){
        int cnt=0;
        
        for(int i=1;i<stations.length;i++){
            if((double)stations[i]-stations[i-1] - m > 1e-6){
                cnt += (int)Math.ceil((stations[i]-stations[i-1])/m) - 1;
            }
        }
        // System.out.println(cnt);
        return cnt<=k;
    }
    public double minmaxGasDist(int[] stations, int k) {
        double l = 0f;
        double r = 0f;
        for(int i=1;i<stations.length;i++){
            r = Math.max(r,stations[i]-stations[i-1]);
        }

        while(r-l >= 1e-6){
            double m = (l+r)/2;
            // System.out.println(l+" "+r+" "+m);
            if(isPossible(stations,m,k)){
                r = m;
            }else{
                l = m;
            }
        }
        return l;
    }
}