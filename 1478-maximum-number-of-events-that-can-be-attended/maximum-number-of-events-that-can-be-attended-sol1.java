class Solution {
    public int maxEvents(int[][] events) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)-> a[1] != b[1] ? a[1] - b[1]:a[0]-b[0]);
        int max = 0;
        for(int []event: events){
            pq.add(event);
            max = Math.max(max,event[1]);
        }
        TreeSet<Integer> tset = new TreeSet<>();
        for(int i=1;i<=max;i++)
            tset.add(i);
        int ans =0 ;
        while(!pq.isEmpty()){
            int t[] = pq.poll();

            Integer d = tset.ceiling(t[0]);
            // System.out.println(d +" "+tset);
            if(d == null || d > t[1]){
                continue;
            }
            
            tset.remove(d);
            ans++;
        }
        return ans;
    }
}
