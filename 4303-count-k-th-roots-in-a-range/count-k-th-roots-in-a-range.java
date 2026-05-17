class Solution {
    public int calculate(double b, double r, boolean ceil){
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
        return ceil ? (int)Math.ceil(res): (int)Math.floor(res);
    }
    public int countKthRoots(int l, int r, int k) {
        if(k == 1)
            return r - l + 1;
        int ul = calculate((double) r , (double)1/k, true);
        int ll = calculate((double) l , (double)1/k , false);
        // System.out.println(ul+" "+ll+" "+r+" "+l +" "+k);
        int ans = 0;
        
        for(int i =ll;i<=ul;i++){
            int temp = (int)Math.pow(i,k) ;
            if(temp <= r && temp >= l)
                ans++;
        }
        return ans;
    }
}