class Pair{
    int val1;
    int val2;
    Pair(int v1,int v2){
        val1  = v1;
        val2 = v2;
    }
}
class Solution {
    public int[] fullBloomFlowers(int[][] intervals, int[] queries) {
         Arrays.sort(intervals,(a,b)-> a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        
        Pair[] mQ = new Pair[queries.length];
        for(int i=0;i<queries.length;i++){
            mQ[i] = new Pair(queries[i],i);
        }
        Arrays.sort(mQ,(a,b)-> a.val1 != b.val1 ? a.val1 - b.val1:a.val2-b.val2);
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.val2 != b.val2 ?a.val2-b.val2:a.val1-b.val1);
        int ans[] = new int[queries.length];
        int k =0;
        for(int i=0;i<queries.length;i++){
            int t = mQ[i].val1;
            int indx = mQ[i].val2;
            while(k<intervals.length && intervals[k][0] <= t){
                pq.add(new Pair(intervals[k][0],intervals[k][1]));
                k++;
            }
            while(!pq.isEmpty() && pq.peek().val2 < t)
                pq.poll();
            if(pq.isEmpty()){
                ans[indx] = 0;
            }else{
                ans[indx] = pq.size();
            }

        }
        return ans;
    }
}

