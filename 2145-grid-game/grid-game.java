class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long arr1[]  = new long[n+1];
        long arr2[] = new long[n+1];
        for(int i=1;i<=n;i++){
            arr1[i] += arr1[i-1] + (long)grid[0][i-1];
            arr2[i] += arr2[i-1] + (long)grid[1][i-1];
        }
        long max = Long.MAX_VALUE;
        // System.out.println(Arrays.toString(arr1)+" \n"+Arrays.toString(arr2));
        for(int i=0;i<n;i++){
            max = Math.min(max, Math.max(arr2[i],arr1[n]-arr1[i+1]));
        }
        return max;
    }
}