class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int prev[] = new int [m+1];
        Arrays.fill(prev,1);
        for(int i=1;i<=n;i++){
            int curr[] = new int[m+1];
            for(int j=1;j<=m;j++){
                curr[j] = curr[j-1];
                if(s.charAt(j-1) == t.charAt(i-1)){
                    curr[j] += prev[j-1] ;
                }
            }
            prev = curr;
        }
        return prev[m];
    }
}