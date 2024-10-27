class Solution {
    public boolean isPossible(int []bloomDay,int days,int m,int k){
        int cnt=0;
        int len =0;
        for(int i:bloomDay){

            if(i <= days){
                len++;
                if(len == k){
                    cnt++;
                    len=0;
                }
            }else{
                len=0;
            }
        }
        return cnt>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int l = 1;
        int r = 0;
        
        for(int i: bloomDay){
            r = Math.max(i,r);
        }
        int max = r;
        while(l<=r){
            int mid = (l+r)/2;
            // System.out.println(l+" "+r+" "+mid + " "+isPossible(bloomDay,mid,m,k) );
            if(isPossible(bloomDay,mid,m,k)){
                r = mid-1;
            }else
                l = mid+1;
        }
        return l <= max ? l:-1 ;
    }
}