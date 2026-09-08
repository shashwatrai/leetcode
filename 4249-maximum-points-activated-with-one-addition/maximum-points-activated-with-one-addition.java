class Solution {
    public int findParent(int a, int []parent){
        if(a == parent[a])
            return a;
        
        return parent[a] = findParent(parent[a],parent);
    }

    public void merge(int a, int b, int [] parent, int cnt[]){
        

        a = findParent(a, parent);
        b = findParent(b, parent);

        if(a != b){
            parent[b] = a;
            cnt[a] += cnt[b];
        }
    }
    public int maxActivated(int[][] points) {
        int g =0 ;
        int n = points.length;
        Map<Integer,Integer> xGrp = new HashMap<>();
        Map<Integer,Integer> yGrp = new HashMap<>();
        
        int parent[] = new int[n];
        int []cnt = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            cnt[i] = 1;
        }

        for(int i=0;i<n;i++){
            if(xGrp.containsKey(points[i][0]) || yGrp.containsKey(points[i][1])){
                int a = xGrp.getOrDefault(points[i][0],parent[i]);
                int b = yGrp.getOrDefault(points[i][1],parent[i]);
                // if(points[i][0] == 288  || points[i][1] == -199)
                //     System.out.println(a+" "+b+" "+parent[i]);
                merge(parent[i],a,parent, cnt);
                merge(parent[i],b,parent, cnt);
            }
            xGrp.put(points[i][0],parent[i]);
            yGrp.put(points[i][1],parent[i]);
        }
        
        for(int i=0;i<n;i++)
            findParent(i, parent);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(0);
        for(int i=0;i<n;i++){
            if(parent[i] == i)
                pq.add(cnt[i]);
        }
        // System.out.println(Arrays.toString(parent));
        // System.out.println(Arrays.toString(cnt));
        return pq.poll() + 1 + pq.poll();

    }
}