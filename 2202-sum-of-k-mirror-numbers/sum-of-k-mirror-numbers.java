class Solution {
    public boolean check(long a, long b){
        StringBuilder stb = new StringBuilder();

        while( a > 0){
            stb.append(Long.valueOf(a%b).toString());
            a /= b;
        }

        String r = stb.toString();
        stb.reverse();
        String f = stb.toString();

        return r.compareTo(f) == 0;
    }
    public long kMirror(int k, int n) {
        
        long ans = 0;
        long start = 1;
        long limit = 10;
        while(n > 0){
            for(long i = start;i < limit && n > 0;i++){
                StringBuilder stb = new StringBuilder(Long.valueOf(i).toString());
                if(i/10L > 0L){
                    StringBuilder temp  = new StringBuilder(Long.valueOf(i/10).toString());
                    temp.reverse();
                    stb.append(temp.toString());
                }
                if(check(Long.parseLong(stb.toString()),(long)k)){
                    // System.out.println(Long.parseLong(stb.toString()));
                    ans += Long.parseLong(stb.toString());
                    n--;
                }
            }
            
            for(long i = start;i < limit && n > 0;i++){
                StringBuilder stb = new StringBuilder(Long.valueOf(i).toString());
               
                StringBuilder temp  = new StringBuilder(Long.valueOf(i).toString());
                temp.reverse();
                stb.append(temp.toString());
                
                if(check(Long.parseLong(stb.toString()),(long)k)){
                    // System.out.println(Long.parseLong(stb.toString()));
                    ans += Long.parseLong(stb.toString());
                    n--;
                }
            }
            start = limit;
            limit *= 10L;
        }
        return ans;
    }
}