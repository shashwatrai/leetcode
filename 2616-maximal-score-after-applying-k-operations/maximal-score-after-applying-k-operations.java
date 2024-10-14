class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i:nums){
            pq.add(i);
        }
        long ans =0;
        while(k-- > 0){
            int num = pq.poll();
            ans += (long)num;
            pq.add((num+2)/3);
        }
        return ans;
    }
}