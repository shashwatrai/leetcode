class Solution {
    public int findParent(int a,int []parent){
        if(a == parent[a])
            return a;
        return parent[a] = findParent(parent[a],parent);
    }

    public void merge(int a, int b,int []parent){
        a = findParent(a,parent);
        b = findParent(b,parent);

        if(a!=b){
            parent[b] = a;
        }
    }
    public int earliestAcq(int[][] logs, int n) {
        Arrays.sort(logs,(a,b)->a[0]-b[0]);
        int []parent = new int[n];
        int minTime[]= new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            minTime[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<logs.length;i++){

            if(findParent(logs[i][1],parent)!=findParent(logs[i][2],parent)){
                merge(logs[i][1],logs[i][2],parent);
                minTime[logs[i][2]] = logs[i][0];
                minTime[logs[i][1]] = logs[i][0];
            }

            
        }

        for(int i=0;i<n;i++){
            findParent(i,parent);
        }
        Set<Integer> set= new HashSet<>();
        for(int i:parent)
            set.add(i);
        if(set.size() > 1)
            return -1;
        // System.out.println(Arrays.toString(minTime));
        int max = 0;
        for(int i:minTime)
            max = Math.max(i,max);
        return max == Integer.MAX_VALUE ? -1:max;
    }
}