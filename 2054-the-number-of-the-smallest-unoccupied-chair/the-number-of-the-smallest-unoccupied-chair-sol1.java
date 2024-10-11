class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        Integer index[] = new Integer[n];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            index[i] = i;
            pq.add(i);
        }

        Arrays.sort(index,(a,b) -> times[a][0] != times[b][0] ? times[a][0] - times[b][0] : times[a][1] - times[b][1] );

        
        TreeMap<Integer,Set<Integer>> tMap = new TreeMap<>();

        int []chair =  new int[n];
        Arrays.fill(chair, -1);

        for(int i:index){
            Integer k = tMap.floorKey(times[i][0]) ;
            while(k != null){
                for(int j: tMap.get(k)){
                    pq.add(j);
                }
                tMap.remove(k);
                k = tMap.floorKey(k);
            }
            if(!tMap.containsKey(times[i][1])){
                tMap.put(times[i][1],new HashSet<>());
            }
            chair[i] = pq.peek();
            tMap.get(times[i][1]).add(pq.poll());
        }
        return chair[targetFriend];
    }
}
