class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long curr=0L;

        long l = lower,r = upper;

        for(int i=0;i<differences.length;i++){
            curr += (long)differences[i];
            l = Math.max(l,lower - curr);
            r = Math.min(r,upper - curr);
        }
        // System.out.println(l+" "+r);
        return (int)Math.max(0,r-l+1);
        

    }
}
// 1 -3 4
// x x+1 x-2 x+2

// 1 2 -1 3
// 6 7 5 8