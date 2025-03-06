class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        long n = grid.length * grid.length;

        long s1 = (n*(n+1))/2;
        long s2 = (n*(n+1)*(2*n+1))/6;
        for(int i[]:grid){
            for(int j:i){
                s1 -= (long)j;
                s2 -= (long)((long)j*(long)j);
            }
        }
        long s3 = s2/s1;
        int b = (int)((s3+s1)/2);
        int a = (int)(s3-(long)b);
        return new int[]{a,b};
    }
}