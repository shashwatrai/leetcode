class Solution {
    public boolean check(long num,String s){
        long r = (long)Math.pow(10L,s.length());
        long p = Long.parseLong(s);
        long t = num%r;
        // System.out.println(t+" "+p);
        return t >= p;

    }

    public long find(long end, boolean isSmall, int m , int n, int l){
        if(m < n)
            return 0L;
        else if(m == n){
            return isSmall? 1L : 0L;
        }
        long r = (long)Math.pow(10L,m-1);
        int d = (int)((long)(end/r)%10);
        // System.out.println(d+" "+l+" "+m+" "+n+" "+r+" "+isSmall+" "+((long)Math.pow(l+1,m-n-1)));
        if(d > l)
            return (long)Math.pow((long)(l+1),m-n);
        else
            return (long)((long)((long)d*(long)Math.pow(l+1,m-n-1)) + (long)find(end,isSmall,m-1,n,l));

    }
    public int countDigit(long d){
        int count =0;
        while(d > 0){
            d  /= 10L;
            count++;
        }
        return count;
    }
    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        int m = countDigit(finish);
        int n = countDigit(start);
        // System.out.println(m+" "+n);
        if(m < s.length())
            return 0L;
        if(m == s.length()){
            Long p = Long.parseLong(s);
            if(p >= start && p <= finish)
                return 1;
            else 
                return 0;
        }

        long lb = find(start - 1,check(start-1L,s),n,s.length(),limit);
        long up = find(finish,check(finish,s),m,s.length(),limit);
        // System.out.println(lb+ " "+ up+" "+check(finish,s));
        return  up-lb ;
    }
}