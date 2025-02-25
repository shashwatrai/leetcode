class Solution {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;
        int dp[][] = new int[n][3];
        int R = (int)1e9 + 7;
        if(arr[0]%2 == 0){
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[0][2] = 0;
        }else{
            dp[0][0] = 0;
            dp[0][1] = 1;
            dp[0][2] = 1;
        }
        for(int i=1;i<n;i++){
            if(arr[i]%2 == 0){
                dp[i][0] = (dp[i-1][0] + 1)%R;
                dp[i][1] = dp[i-1][1];
                dp[i][2] = (dp[i-1][2]%R + dp[i-1][1]%R)%R;
            }else{
                dp[i][0] = dp[i-1][1];
                dp[i][1] = (dp[i-1][0] + 1)%R;
                dp[i][2] = (dp[i-1][2]%R + dp[i-1][0]%R + 1)%R;
            }
        }
        return dp[n-1][2];
    }
}