class Solution {
    public int minCost(String colors, int[] neededTime) {
        int n = neededTime.length;
        

        int start = 0;
        int max = neededTime[0];
        int ans = 0;
        int sum=neededTime[0];
        for(int i =1;i<n;i++){
            if(colors.charAt(i) != colors.charAt(start) ){
                ans += sum - max;
                max = sum = neededTime[i];
                start = i;
            }else{
                max = Math.max(max,neededTime[i]);
                sum += neededTime[i];
            }
        }
        ans += sum - max;
        return ans;
    }
}