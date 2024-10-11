class Solution {
    public int smallestChair(int[][] times, int targetFriend) {

        int n = times.length;

        int targetArrival = times[targetFriend][0];

        Arrays.sort(times,(a,b)-> a[0] - b[0]);

        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> a[0] - b[0]);
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0;i<n;i++)
            set.add(i);

        for(int i=0;i<n;i++){
            int a = times[i][0];
            int d = times[i][1];

            while(!pq.isEmpty() && pq.peek()[0] <= a){
                set.add(pq.poll()[1]);
            }

            int curr = set.first();
            set.remove(curr);

            if(a == targetArrival)
                return curr;
            
            pq.add(new int[]{d,curr});
        } 
        return -1;
    }
}