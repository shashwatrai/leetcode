class Solution {
    public int findCeil(int []nums,int t){
        int l = 0,r = nums.length-1;

        while(l<=r){
            int m = (l+r)/2;

            if(nums[m] >= t )
                r = m-1;
            else
                l = m+1;
        }
        return l;
    }
    public int findFloor(int []nums,int t){
        int l=0,r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;

            if(nums[m] <= t)
                l = m+1;
            else
                r = m-1;
        }
        return r;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long cnt=0L;
        for(int i=0;i<nums.length;i++){
            int lb = findCeil(nums,lower-nums[i]);
            int rb= findFloor(nums,upper-nums[i]);
            
            int diff = rb-lb+1;
            // System.out.println(diff+" "+lb+" "+rb);
            if( i >= lb && i<= rb)
                diff--;
            cnt += (long)diff;
        }
        return (long)cnt/2L;
    }
}
