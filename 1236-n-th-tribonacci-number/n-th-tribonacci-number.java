class Solution {
    public int tribonacci(int n) {
        if(n == 0)
            return 0;
        else if(n == 1 || n== 2)
            return 1;
        else{
            int ppp = 0;
            int pp = 1;
            int p = 1;

            int curr =0;

            for(int i=3;i<=n;i++){
                curr = p + pp + ppp;
                ppp = pp;
                pp =p;
                p = curr;
            }
            return curr;

        }
    }
}