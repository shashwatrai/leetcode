class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        // to store the sum before the index
        int sumTillNow = 0;
        int k =0;
        int n = nums.length;
        int diff[] = new int[n];

        for(int i=0;i<n;i++){

            

            while(k < queries.length && sumTillNow + diff[i] < nums[i]){
                int l = queries[k][0];
                int r = queries[k][1];
                int v = queries[k][2];
                if(r >= i){ // before i all the elements are set to 0, target is acheived. so no need to apply
                    diff[Math.max(i,l)] += v;
                    if(r+1 < n){
                        diff[r+1] -= v;
                    }
                } 
                k++;
            }
            if(k == queries.length && sumTillNow + diff[i] < nums[i] )
                return -1;
            sumTillNow += diff[i];
            
        }
        return k;
    }
}