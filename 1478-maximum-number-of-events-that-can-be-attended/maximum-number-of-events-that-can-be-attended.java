class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events,(a,b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> a - b);
        int max = 0;
        for(int []event: events){
            max = Math.max(max,event[1]);
        }
        int ans =0 ;
        for(int i=1,j=0;i<=max;i++){
            while(j < events.length && events[j][0] <= i){
                pq.add(events[j][1]);
                j++;
            }
            
            while(!pq.isEmpty()  && pq.peek() < i)
                pq.poll();

            if(!pq.isEmpty()){
                ans++;
                pq.poll();
            }
        }
        
        return ans;
    }
}