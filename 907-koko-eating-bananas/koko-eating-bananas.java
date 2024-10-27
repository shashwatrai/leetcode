class Solution {
    public boolean isValid(int []piles,int m, int h){
        int cnt =0;
        for(int i:piles){
            cnt += Math.ceil((double)i/m);
        }
        return cnt <= h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int r = piles[0];
        for(int i:piles){
            r = Math.max(i,r);
        }
        int l = 1;

        while(l<=r){
            int m = (l+r)/2;

            if(isValid(piles,m,h))
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
}