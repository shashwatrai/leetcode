class Pair{
    int wt;
    int indx;
    double p;
    int cnt;
    Pair(int w,int i,double p){
        this.wt = w;
        this.indx = i;
        this.p = p;
        this.cnt = 0;
    }
}
class Solution {
    int call;
    PriorityQueue<Pair> pq;
    public Solution(int[] w) {
        call =0;

        pq = new PriorityQueue<>((a,b)->{
            int d1 = a.cnt - (int)Math.round(a.p*call);
            int d2 = b.cnt - (int)Math.round(b.p*call);
            // System.out.println("("+a.wt+" "+d1 +" "+b.wt+" "+d2+")");
            if(d1 != d2)    
                return d1-d2;
            else
                return a.p < b.p ? 1: -1;
        });
        int sum=0;
        for(int i:w)
            sum+=i;
        for(int i=0;i<w.length;i++){
            pq.add( new Pair(w[i],i,(double)w[i]/sum));
        }
    }
    
    public int pickIndex() {
        
        call++;
        // System.out.println("polling");
        Pair p = pq.poll();
        p.cnt++;
        pq.add(p);
        // System.out.println(pq.peek().cnt+" "+pq.peek().wt);
        return p.indx;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */