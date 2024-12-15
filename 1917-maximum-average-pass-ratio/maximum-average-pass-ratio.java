class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int []> pq = new PriorityQueue<>((a,b)->{
            Double r1 = (double)(a[0]+1)/(a[1]+1) - (double)(a[0])/(a[1]);
            Double r2 = (double)(b[0]+1)/(b[1]+1) - (double)(b[0])/(b[1]);

            return -1 * Double.compare(r1,r2);
        });

        for(int i[]:classes)
            pq.add(i);

        while(extraStudents-- > 0){
            int[] curr = pq.poll();
            curr[0]++;
            curr[1]++;
            pq.add(curr);
        }
        double ans =0f;
        while(!pq.isEmpty()){
            int []curr = pq.poll();
            // System.out.println(Arrays.toString(curr));
            ans += (double)(curr[0])/curr[1];
        }
        return ans/classes.length;
    }
}