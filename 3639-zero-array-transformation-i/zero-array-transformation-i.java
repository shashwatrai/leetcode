class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int res[] = new int[n];

        for(int i=0;i<queries.length;i++){
            res[queries[i][0]]--;
            if(queries[i][1] + 1 < n)
                res[queries[i][1]+1]++;
        }
        // System.out.println(Arrays.toString(res));
        if(res[0] + nums[0] > 0)
            return false;
        
        for(int i=1;i<n;i++){
            res[i] += res[i-1];
            if(res[i] + nums[i] > 0)
                return false;
        }
        
        return true;
        
    }
}