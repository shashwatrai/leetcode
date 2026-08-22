class Solution {
    public boolean checkDivisibility(int n) {
        int n1 = 0, n2 = 1;

        int t = n ;

        while(t > 0){
            n1 += t%10;
            n2 *= t%10;

            t /= 10;
        }

        return n % (n1+n2) == 0;
    }
}