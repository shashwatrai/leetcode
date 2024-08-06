class Solution {
    public boolean isPossible(int []piles,int speed,int h){
        int t=0;
        for(int i:piles){
            t += Math.ceil((double)i/speed);
        }
        return t <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        
        int l = 1,r = 0;
        for(int i:piles)
            r = Math.max(i,r);
        
        while(l<=r){
            int m = (l+r)/2;
            if(isPossible(piles,m,h)){
                r = m-1;
            }else
                l = m+1;
        }

        return l;
    }
}