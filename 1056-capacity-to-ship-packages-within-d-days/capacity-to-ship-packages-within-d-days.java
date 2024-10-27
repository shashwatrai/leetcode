class Solution {
    public boolean isPossible(int []weights,int wt,int t ){
        int sum=0;
        int cnt=1;
        for(int i:weights){
            if(i > wt)
                return false;
            sum +=i;
            if(sum > wt){
                cnt++;
                sum=i;
            }
        }
        return cnt  <= t;
    }
    public int shipWithinDays(int[] weights, int days) {
        int l = 1;
        int r = 0;
        for(int i:weights)
            r+=i;
        
        while(l<=r){
            int mid = (l+r)/2;
            if(isPossible(weights,mid,days))
                r = mid-1;
            else
                l = mid+1;
        }
        return l;
    }
}