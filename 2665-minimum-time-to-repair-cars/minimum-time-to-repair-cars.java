class Solution {
    public long repairCars(int[] ranks, int cars) {
        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<ranks.length;i++){
            map.put(ranks[i],map.getOrDefault(ranks[i],0)+1);
        }

        PriorityQueue<long[]> pq = new PriorityQueue<>((a,b)-> Long.compare(a[1]*(a[2]+1L)*(a[2]+1L),b[1]*(b[2]+1L)*(b[2]+1L)));
        for(int i:map.keySet()){
            pq.add(new long[]{i,i,0,map.get(i)});
        }
        long ans = 0L;
        while(cars > 0){
            long[] curr = pq.poll();

            cars -= curr[3];
            curr[2]++;
            curr[0] = curr[1]*curr[2]*curr[2];
            // System.out.println(cars+" "+ans+" "+Arrays.toString(curr));
            ans = Math.max(ans,curr[0]);
            pq.add(curr);
        }
        return ans;
    }
}