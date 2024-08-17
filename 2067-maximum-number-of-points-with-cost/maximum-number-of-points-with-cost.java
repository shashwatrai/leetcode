class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;

        long []prev= new long[n];
        for(int i=0;i<n;i++)
            prev[i] = (long)points[0][i];


        for(int i=1;i<m;i++){
            long left[] = new long[n];
            long right[] = new long[n+1];

            long curr[] = new long[n];

            left[0] = prev[0];
            for(int j=1;j<n;j++){
                // adding the j to prev, so that in the later stage if col is subtracted, it would lead to substraction of the distance.
                left[j] = Math.max(left[j-1],prev[j]+j);
            }
            right[n] = -n+1;
            right[n-1] = prev[n-1] - (n - 1);
            for(int j=n-2;j>=0;j--){
                // subtracting the j to prev, so that in the later stage if col is add, it would lead to substraction of the distance.
                right[j] = Math.max(right[j+1],prev[j]-j);
            }

            for(int j=0;j<n;j++){
                curr[j] = points[i][j] + Math.max(left[j]-j,right[j+1]+j);
            }
            
            prev = curr;
        }
        long ans = Long.MIN_VALUE;
        for(long i:prev)
            ans = Math.max(ans,i);
        return ans;
    }
}