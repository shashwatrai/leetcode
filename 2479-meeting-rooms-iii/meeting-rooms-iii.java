class Solution {
    public int mostBooked(int n, int[][] meetings) {
        int count[] = new int[n];

        Arrays.sort(meetings,(a,b)-> a[0]-b[0]);

        PriorityQueue<long []> pq = new PriorityQueue<>((a,b)->a[0] != b[0] ? Long.compare(a[0], b[0]):Long.compare(a[1], b[1]));
        PriorityQueue<Integer> unusedRoom = new PriorityQueue<>();
        for(int i=0;i<n;i++){
            unusedRoom.add(i);
        }

        for(int i=0;i<meetings.length;i++){

            while(!pq.isEmpty() && pq.peek()[0] <= (long)meetings[i][0]){
                unusedRoom.add((int)pq.poll()[1]);
            }

            if(unusedRoom.isEmpty()){
                long []arr = pq.poll();
                if(arr[0] > (long)((long)arr[0] - (long)meetings[i][0] + (long)meetings[i][1])){
                    System.out.println("Faulty:"+ i +" "+meetings[i][0]+" "+meetings[i][1]+" "+Arrays.toString(arr));
                }
                arr[0] = (long)((long)arr[0] - (long)meetings[i][0] + (long)meetings[i][1]);
                count[(int)arr[1]]++;

                // System.out.println(i+" "+Arrays.toString(arr));
                pq.add(arr);
                
            }else{
                int room = unusedRoom.poll();
                count[room]++;
                pq.add(new long[]{meetings[i][1],room});
            }
        }
        // System.out.println(Arrays.toString(count));
        int ans=0,max= 0;
        for(int i=0;i<n;i++){
            if(max < count[i]){
                ans = i;
                max = count[i];
            }
        }
        return ans;
    }

}