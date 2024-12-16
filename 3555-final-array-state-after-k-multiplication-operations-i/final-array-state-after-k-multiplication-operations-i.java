class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> nums[a] != nums[b] ? nums[a] - nums[b]:
           a - b );
        for(int i=0;i<nums.length;i++){
            pq.add(i);
        }

        while(k-- > 0){
            int curr = pq.poll();
            nums[curr] *= multiplier;
            pq.add(curr);
        }
        return nums;
    }
}