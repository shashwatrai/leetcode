class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int sum[] = new int [2*limit + 2];

        for(int i=0;i<n/2;i++){
            int b = Math.max(nums[i],nums[n-1-i]);
            int a = Math.min(nums[i],nums[n-1-i]);

            sum[0] += 2;
            sum[a+1] += -1;
            sum[a+b] += -1;
            sum[a+b+1] += 1;
            sum[b+limit+1] += 1;
        }

        int cost = Integer.MAX_VALUE;
        for(int i=1;i<sum.length;i++){
            sum[i] += sum[i-1];
            cost = Math.min(sum[i],cost);
        }

        // System.out.println(Arrays.toString(sum));
        return cost;
    }
}