class Solution {
    
    public void merge(int a,int b,int []parent){
        if(a == b)
            return ;

        a = findParent(a,parent);
        b = findParent(b,parent);
        
        if(a!=b){
            parent[b] = a;
        }
    }
    public int findParent(int a,int []parent){
        if(parent[a] == a)
            return a;
        return parent[a] = findParent(parent[a],parent);
    }
    public int countComponents(int n, int[][] edges) {
        int parent[] = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;
    
        for(int i=0;i<edges.length;i++){

                merge(edges[i][0],edges[i][1],parent);

        }

        for(int i=0;i<n;i++){
            findParent(i,parent);
        }
        Set<Integer> hashSet = new HashSet<>();
        for(int i=0;i<n;i++){
            hashSet.add(parent[i]);
        }
        return hashSet.size();
    }
}