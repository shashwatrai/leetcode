class Solution {

    public boolean traverse(int [][]graph,int curr,int []color,int pColor){
        color[curr] = 1 - pColor;

        for(int j: graph[curr]){
            if(color[j] == -1){
                if(!traverse(graph,j,color,1-pColor))
                    return false;
            }else{
                if(color[j] == color[curr])
                    return false;
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;

        int []color = new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++){
            if(color[i] == -1){
                if(!traverse(graph,i,color,1))
                    return false;
            }
        }
        return true;
    }
}