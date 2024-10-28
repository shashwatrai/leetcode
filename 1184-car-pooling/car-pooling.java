class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Arrays.sort(trips,(a,b)-> a[1] != b[1] ? a[1] - b[1] 
            : a[2] != b[2] ? a[2] - b[2] : a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);

        for(int i=0;i<trips.length;i++){
            while(!pq.isEmpty() && pq.peek()[2] <= trips[i][1]){
                capacity += pq.poll()[0];
            }

            if(capacity < trips[i][0])
                return false;
            
            capacity -= trips[i][0];
            pq.add(trips[i]);
        }
        return true;
    }
}