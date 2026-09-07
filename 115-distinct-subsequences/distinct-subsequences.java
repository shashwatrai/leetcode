class Solution {
    public int numDistinct(String s, String t) {
        int n =  s.length();

        int prev[] = new int[n+1];
        Arrays.fill(prev,1);
        for(int i=1;i<=t.length();i++){
            int curr[] = new int[n+1];

            for(int j=1;j<=n;j++){
                curr[j] =  curr[j-1];
                if(t.charAt(i-1) == s.charAt(j-1))
                    curr[j] += prev[j-1];
            }
            prev = curr;
        }
        return prev[n];
    }
}