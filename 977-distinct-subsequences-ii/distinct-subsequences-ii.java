class Solution {
    public int distinctSubseqII(String s) {
        long R = 1_000_000_007L;
        int n= s.length();
        long arr[] = new long[n];

        for(int i=0;i<n;i++){
            arr[i] = 1L;
            for(int j=i-1;j>=0;j--){
                if(s.charAt(i) == s.charAt(j))
                    continue;
                arr[i] = (arr[i]%R + arr[j]%R)%R;
            }
        }
        long ans  = 0L;
        for(long i: arr){
            ans = (ans%R + i%R)%R;
        }
        return (int)ans;
    }
}