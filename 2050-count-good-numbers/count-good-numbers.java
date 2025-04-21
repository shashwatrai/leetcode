class Solution {
    public long power(long a, long b){
        long R = (int)1e9+7;
        long res=1;
        while( b > 0){
            if((b&1) == 1){
                res = ((res%R)*(a%R))%R;
            }
            b >>= 1;
            a = (a*a)%R;
        }
        return res%R;
    }
    public int countGoodNumbers(long n) {
        long e = (n+1)/2;
        long o = n - e;

        long ec = power(5,e);
        long oc = power(4,o);
        long R = (int)1e9+7;
        long ans = ((long)(ec%R) * (long)(oc%R))%R;
        return (int)ans;
    }
}

