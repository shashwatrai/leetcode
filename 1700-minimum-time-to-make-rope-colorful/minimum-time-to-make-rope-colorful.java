class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        int sum[]   = new int[n];

        sum[0] = neededTime[0];
        for(int i =1;i<n;i++){
            sum[i] += sum[i-1] + neededTime[i];
        }

        int start = 0;
        int max = neededTime[0];
        int ans = 0;
        for(int i =1;i<n;i++){
            if(colors.charAt(i) != colors.charAt(start) ){
                ans += sum[i-1] - (start > 0 ? sum[start-1]:0) - max;
                max = neededTime[i];
                start = i;
            }else{
                max = Math.max(max,neededTime[i]);
            }
        }
        ans += sum[n-1] - (start > 0 ? sum[start-1]:0) - max;
        return ans;
    }
}