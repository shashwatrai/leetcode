class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int cnt[] = new int[n];

        for(int i=0;i<n;i++){
            if(s.charAt(i) == '1')
                cnt[i]++;
        }

        for(int i=1;i<n;i++)
            cnt[i] += cnt[i-1];
        
        int ans = n - cnt[n-1];
        for(int i=0;i<n;i++){
            ans = Math.min(ans, cnt[i] + n - 1- i - cnt[n-1] + cnt[i]);
        }
        return ans;
    }
}