class Solution {
    public int calculate(double b, double r){
        double res = 1f;
        double p = 1f;
        while(r > 0f){
            if(r >= p){
                res = res * b;
                r -= p;
            }
            p = p/2f;
            b = Math.sqrt(b);
        }
        return  (int)Math.ceil(res);
    }
    public int countKthRoots(int l, int r, int k) {
        if(k == 1)
            return r - l + 1;
        int ul = calculate((double) r , (double)1/k);
        int ll = calculate((double) l , (double)1/k);
        
        boolean boundary = Math.pow(ul,k) <= r;

        return ul - ll + (boundary ? 1: 0); 
    }
}