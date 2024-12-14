class Solution {
    public long continuousSubarrays(int[] nums) {
        int n= nums.length;

        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        int start = 0;
        long ans = 0L;
        for(int i=0;i<n;i++){
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()]  > nums[i])
                minDeque.pollLast();
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()]  < nums[i])
                maxDeque.pollLast();
            minDeque.addLast(i);
            maxDeque.addLast(i);

            while(  nums[maxDeque.peekFirst()]  - nums[minDeque.peekFirst()]   > 2){
                ans += (i-start);
                if(maxDeque.peekFirst() == start){
                    maxDeque.pollFirst();
                }
                if(minDeque.peekFirst() == start){
                    minDeque.pollFirst();
                }
                start++;
            }
        }
        // System.out.println(minDeque + " \n"+maxDeque);
        ans += (long)(n-start) * (long)(n-start+1)/2;
        return ans;
    }
}
