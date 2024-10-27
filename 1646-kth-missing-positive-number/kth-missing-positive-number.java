class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0,r = arr.length-1;

        while(l<=r){
            int m = (l+r)/2;
            int missing = arr[m] - m - 1;
            if(missing >= k)
                r = m-1;
            else
                l = m+1;
        }
        return  (r>=0 ? arr[r]:0) + k - (r >=0 ? (arr[r] - r -1):0);

    }
}