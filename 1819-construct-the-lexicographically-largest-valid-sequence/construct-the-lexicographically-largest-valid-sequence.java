class Solution {
    public boolean findAns(int []ans, boolean []vis, int indx,int []max,int remaining){
        // System.out.println(Arrays.toString(ans) +" "+indx+" "+remaining);
        if(remaining == 0){
            return true;
        }
        if(ans[indx] != 0)
            return findAns(ans,vis,indx+1,max,remaining);
        for(int i=vis.length-1;i>0 ;i--){
            if(!vis[i] && ans[indx] == 0 && (i == 1 || (indx+i < ans.length && ans[indx+i] == 0))){
                if(i != 1)
                    ans[i+indx] = i;
                ans[indx] = i;
                vis[i] = true;
                if(findAns(ans,vis,indx+1,max,remaining-1))
                    return true;
                if(i!=1)
                    ans[i+indx] = 0;
                
                ans[indx] = 0;
                vis[i] = false;
            }
        }
        return false;
    }

    public int[] constructDistancedSequence(int n) {
        int []ans = new int[2*n-1];
        boolean []vis = new boolean[n+1];

        findAns(ans,vis,0,new int[n],n);
        return ans;
    }
}