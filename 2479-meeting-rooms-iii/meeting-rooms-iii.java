class Pair{
    int time; 
    int room;
    Pair(int t,int r){
        this.time = t;
        this.room = r;
    }
}
class Solution {
    public int mostBooked(int n, int[][] meetings) {
        
        PriorityQueue<Pair> arrangements = new PriorityQueue<>((a,b)-> a.time != b.time? a.time-b.time : a.room - b.room);
        PriorityQueue<Integer> rooms  = new PriorityQueue<>();
        
        for(int i=0;i<n;i++)
            rooms.add(i);
        
        Arrays.sort(meetings, (a,b)-> a[0] != b[0] ? a[0] - b[0] : a[1]- b[1]);
        int []freq = new int[n];
        for(int i=0;i<meetings.length;i++){
            while(!arrangements.isEmpty() && arrangements.peek().time <= meetings[i][0]){
                rooms.add(arrangements.poll().room);
            }

            
            int time = meetings[i][1];
            if(rooms.isEmpty()){
                Pair p = arrangements.poll();
                time = p.time - meetings[i][0] + meetings[i][1];
                rooms.add(p.room);
            }
            int room = rooms.poll();
            freq[room]++;
            arrangements.add(new Pair(time,room));
        }

        int max =0;
        int ans= -1;
        for(int i=0;i<n;i++){
            if(max < freq[i]){
                ans = i;
                max = freq[i];
            }
        }
        return ans;
    }
}