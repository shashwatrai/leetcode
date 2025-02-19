class TreeAncestor {
    int n ;
    int parent[];
    int [][]dp;
    int h;
    public TreeAncestor(int n, int[] parent) {
        this.parent = parent;
        this.n = n;

        h = (int)Math.ceil(((double)Math.log(n)/Math.log(2)));
        dp = new int[n][h+1];

        for(int i=0;i<n;i++){
            dp[i][0] = parent[i];
        }

        for(int i=1;i<=h;i++){
            for(int j=0;j<n;j++){
                dp[j][i] = -1;
                if(dp[j][i-1] != -1)
                    dp[j][i] = dp[dp[j][i-1]][i-1]; 
            }
        }
    }
    
    public int getKthAncestor(int node, int k) {
        int curr = node;
        // System.out.println(Arrays.toString(dp[node]));
        int a = 0;
        while(k >= (1<<a) && curr != -1){
            System.out.println(node+" "+curr);
            if((k&(1<<a)) != 0)
                curr = dp[curr][a];
            a++;
        }
        return curr;
    }
}

/**
 * Your TreeAncestor object will be instantiated and called as such:
 * TreeAncestor obj = new TreeAncestor(n, parent);
 * int param_1 = obj.getKthAncestor(node,k);
 */