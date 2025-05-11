class Solution {
    public boolean isStrictlyPalindromic(int n) {
        boolean ans = true;

        for(int i=2;i<=n-2;i++){
            StringBuilder stb = new StringBuilder();

            int t = n;

            while(t > 0){
                stb.append((char)(t%i));
                t/=i;
            }
            stb.reverse();
            String res = stb.toString();
            for(int a = 0,b=res.length() - 1 ; a<b;a++,b--){
                if(res.charAt(a) != res.charAt(b))
                    return false;
            }
        }
        return true;
    }
}