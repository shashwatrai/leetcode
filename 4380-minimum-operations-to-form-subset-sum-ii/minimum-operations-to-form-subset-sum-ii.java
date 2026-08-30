class Solution {
    public int solve(List<int[]> arr[],int n ,int curr, int target ,int dp[][]){
        if(target == 0)
            return 0;
        if(curr >= n)
            return -1;

        if(dp[curr][target] != Integer.MAX_VALUE)
            return dp[curr][target];
        
        int currTake = solve(arr,n,curr+1,target,dp);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr[curr].size();i++){
            int temp[] = arr[curr].get(i);

            if(temp[0] > target)
                continue;

            int newScore = solve(arr,n,curr+1,target-temp[0],dp);
            if(newScore == -1)
                continue;
            min = Math.min(min ,newScore + temp[1] );
        }
        if(currTake != -1)
            min = Math.min(currTake,min);
        if(min == Integer.MAX_VALUE)
            min = -1;
        return dp[curr][target] = min;
    }

    public int minOperations(int[] nums, int sum) {
        int n = nums.length;
        List<int[]> arr[] = new List[n];

        for(int i=0;i<n;i++){
            List<int[]> temp = new ArrayList<>();
            int curr = nums[i];
            int count = 0;
            while(curr >= 1){
                int tempCurr = curr;
                int tempCount = count;

                while(tempCurr <= sum){
                    temp.add(new int[]{tempCurr,tempCount});
                    tempCurr *= 2;
                    tempCount++;
                }
                curr/=2;
                count++;
            }
            arr[i] = temp;

        
        }
        // for(int i=0;i<n;i++){
        //     for(int j[]:arr[i]){
        //         System.out.print(Arrays.toString(j)+",");
        //     }
        //     System.out.println();
        // }
        int [][]dp= new int[n][5001];
        for(int i[]:dp)
            Arrays.fill(i,Integer.MAX_VALUE);
        
        int ans = solve(arr,n,0, sum,dp);
        if(ans != Integer.MAX_VALUE)
            return ans;
        return -1;
    }
}