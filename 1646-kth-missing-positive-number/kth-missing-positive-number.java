class Solution {
    public int lowerBound(int []arr,int t){
        int l = 0,r = arr.length-1;

        while(l<=r){
            int m = (l+r)/2;
            if(arr[m] >= t)
                r= m-1;
            else
                l = m+1;
        }
        return l;
    }
    public int findKthPositive(int[] arr, int k) {
        int l = 1,r= 10001;
        while(l<=r){
            int m = (l+r)/2;

            int indx = lowerBound(arr,m);
            
            int left = (m-1-indx) + (indx == arr.length || arr[indx] != m ? 1:0);
            if(left >= k)
                r  = m - 1;
            else
                l = m + 1;
        }
        return l;
    }
}