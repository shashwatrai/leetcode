class Solution {
    public boolean isPossible(int []arr,long k,int c){
        long s  =0L;

        for(int i:arr){
            s += (long)(i/c);
        }
        return s >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        
        int ans =0;

        int l = 1,r = 10000001;

        while(l<=r){
            int mid = (l+r)/2;


            if(isPossible(candies,k,mid)){
                ans = mid;
                l=mid+1;
            }else
                r = mid-1;
        }

        return ans;

    }
}