class Solution {
    public int nthUglyNumber(int n) {
        int []arr = new int[n];

        arr[0] = 1;

        int indx2,indx3,indx5;

        indx2= indx3 = indx5 = 0;
        for(int i=1;i<n;i++){
            int min = Math.min( arr[indx2]*2 > 0 ? arr[indx2]*2:Integer.MAX_VALUE,
                            Math.min(arr[indx3]*3 > 0 ? arr[indx3]*3:Integer.MAX_VALUE,
                            arr[indx5]*5 > 0 ? arr[indx5]*5:Integer.MAX_VALUE) );
            
            arr[i] = min;

            if( arr[indx2]*2 == arr[i])
                indx2++;
            if( arr[indx3]*3 == arr[i])
                indx3++;
            if( arr[indx5]*5 == arr[i])
                indx5++;
        }
        return arr[n-1];
    }
}