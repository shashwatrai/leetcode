class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long left =0;
        long right=0;
        for(int i=0;i<n;i++){
           right+= grid[0][i];
        }
        long max = Long.MAX_VALUE;
        // System.out.println(Arrays.toString(arr1)+" \n"+Arrays.toString(arr2));
        for(int i=0;i<n;i++){
            max = Math.min(max, Math.max(left,right - grid[0][i]));
            right -= (long)grid[0][i];
            left += (long)grid[1][i];
        }
        return max;
    }
}