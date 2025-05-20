class Solution {
    public boolean isPossible(List<Integer> arr,int indx,int sum,int [][]dp){
        if(sum == 0){
            if(indx < arr.size())
                dp[indx][sum] = 2;
            return true;
        }else if(indx >= arr.size())
            return false;
        
        if(dp[indx][sum] > 0)
            return dp[indx][sum] == 2;
        
        boolean without  = isPossible(arr,indx+1 ,sum,dp);
        if(without){
            dp[indx][sum] = 2;
            return true;
        }
        boolean with = false;
        if(sum-arr.get(indx) >= 0)
            with  = isPossible(arr,indx+1 ,sum-arr.get(indx),dp);
        
        dp[indx][sum] = with || without ? 2: 1;
        return with || without;
    }
    public boolean isValid(int []nums,int [][]queries,int m){
        List<Integer> res[] = new List[nums.length];
        for(int i=0;i<res.length;i++)
            res[i] = new ArrayList<>();
        for(int i=0;i<=m;i++){
            for(int j= queries[i][0];j<=queries[i][1];j++){
                res[j].add(queries[i][2]);
            }
        }

        for(int i=0;i<res.length;i++){
            if(!isPossible(res[i],0,nums[i],new int[res[i].size()][nums[i]+1]))
                return false;
        }

       
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        
        int l = 0;
        int r = queries.length-1;

        while(l<=r){
            int m = (l+r)/2;
            System.out.println(m +" "+isValid(nums,queries,m));
            if(isValid(nums,queries,m))
                r = m-1;
            else
                l = m+1;
        }
        if(l == 0){
            int s=0;
            for(int i:nums)
                s+=i;
            if(s== 0)
                return 0;
        }
        return l == queries.length?-1:l+1;
    }
}