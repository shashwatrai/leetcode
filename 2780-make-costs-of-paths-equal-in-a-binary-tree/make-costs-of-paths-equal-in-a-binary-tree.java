class Solution {
    public int solve(int indx,int n ,int []cost,int ans[]){
        if(indx >= n)
            return 0;
        
        int left = solve(2*indx+1,n,cost,ans);
        int right = solve(2*indx+2,n,cost,ans);

        ans[0] += Math.abs(left-right);
        
        return Math.max(left,right)+cost[indx];
    }
    public int minIncrements(int n, int[] cost) {
        int ans[] = new int[1];
        solve(0,n,cost,ans);
        return ans[0];
    }
}