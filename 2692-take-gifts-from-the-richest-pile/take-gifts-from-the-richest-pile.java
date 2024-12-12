class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        long ans = 0L;
        for(int i:gifts){
            pq.add(i);
            ans += (long)i;
        }

        while(k-- > 0){
            int t = pq.poll();
            ans -= (long)(t - (int)Math.sqrt(t));
            pq.add((int)Math.sqrt(t));
        }
        return ans;
    }
}