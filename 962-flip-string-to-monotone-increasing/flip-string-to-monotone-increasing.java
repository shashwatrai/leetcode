class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int cnt=0;

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1')
                cnt++;
        }

        
        int ans = n - cnt;
        int curr = 0 ;
        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1')
                curr++;
            ans = Math.min(ans, curr + n - 1- i - cnt + curr);
        }
        return ans;
    }
}