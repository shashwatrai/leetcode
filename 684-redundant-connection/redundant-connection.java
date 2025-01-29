class Solution {
    public int findParent(int a,int []parent){
        if(a == parent[a])
            return a;
        return parent[a] = findParent(parent[a],parent);
    }

    public void merge(int a,int b,int []parent){
        a = findParent(a,parent);
        b = findParent(b,parent);


        parent[b] = a;
        
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n= edges.length;
        int []parent = new int[n+1];

        for(int i=1;i<=n;i++){
            parent[i] = i;
        }
        for(int i=0;i<n;i++){
            if(findParent(edges[i][0],parent) != findParent(edges[i][1],parent))
                merge(edges[i][0],edges[i][1],parent);
            else
                return edges[i];
        }
        return new int[0];
    }
}