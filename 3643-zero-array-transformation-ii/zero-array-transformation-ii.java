class Solution {
    public boolean isPossible(int []nums, int [][]queries,int k){
        int diff[] = new int[nums.length];
        for(int i=0;i<=k;i++){
            diff[queries[i][0]]+=queries[i][2];
            if(queries[i][1] + 1 < diff.length)
                diff[queries[i][1]+1]-=queries[i][2];
        }
        if(diff[0] < nums[0])
            return false;
        for(int i=1;i<diff.length;i++){
            diff[i] += diff[i-1];
            if(diff[i] < nums[i])
                return false;
        }
        // System.out.println(Arrays.toString(diff)+" "+Arrays.toString(nums));
        return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        

        int m  = queries.length;
        int l = 0,r = m-1;
        int ans = -1;
        if(isPossible(nums,queries,-1))
            return 0;
        while(l <= r){
            int mid = (l+r)/2;

            if(isPossible(nums,queries,mid)){
                ans = mid+1;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}