class Solution {
    public int differenceOfSums(int n, int m) {
        int d = n/m;

        int s1 = (n * (n+1))/2;
        int s2 = (d * (2 * m + (d - 1) * m) )/2;
        return s1 - 2 * s2;
    }
}