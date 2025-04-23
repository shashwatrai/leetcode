class Solution {
    long factorial[];
    public long inverse(long a){
        long copy = a;
        int b = 1000000005;
        long R = 1000000007;
        long res = 1L;
        
        while(b > 0){
            if(b%2 == 1){
                res = (res%R * a%R)%R;
            }
            b/=2;
            a = (a%R * a%R)%R;
        }


        
        return res;
    }
    public long calculate(int p,int n){
        long n1 = factorial[n+p-1];
        long d1  = inverse(factorial[n-1]);
        long d2 = inverse(factorial[p]);
        long R = 1000000007;    
        return ((n1%R * d1%R)%R * d2%R)%R;
    }
    public int idealArrays(int n, int maxValue) {
        
        long R = 1000000007;
        factorial = new long[10101];
        factorial[0] = factorial[1]  = 1L;
        for(int i = 1;i<10101;i++){
            factorial[i] = ((long)i * factorial[i-1]%R)%R;
        }
        boolean raw[] = new boolean[10001];
        List<Integer> prime = new ArrayList<>();
        for(int i=2;i<raw.length;i++){
            if(!raw[i] ){
                prime.add(i);
                for(int j = i;j<raw.length;j+=i){
                    raw[j] = false; 
                }
            }
        }
        long ans = 1L;

        for(int i=2;i<=maxValue;i++){
            Map<Integer,Integer> factors = new HashMap<>();

            int t = i;
            for(int j : prime){
                while(t > 1 && t%j == 0){
                    factors.put(j,factors.getOrDefault(j,0)+1);
                    t/=j;
                    
                }

                if(t==1)
                    break;
                
            }
            long temp = 1L;
           
            for(int j:factors.keySet()){
                temp = (temp%R * calculate(factors.get(j),n)%R)%R;
            }
            // System.out.println(i+" "+factors+" "+temp);
            ans = (ans%R + temp%R)%R;
        }
        return (int)ans;
        
    }
}