class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans[] = new int[100001];

        for(int i=0;i<difficulty.length;i++){
            ans[difficulty[i]] = Math.max(ans[difficulty[i]],profit[i]);
        }

        int max = 0;
        for(int i=0;i<ans.length;i++){
            ans[i] = Math.max(ans[i],max);
            max = Math.max(ans[i],max);
        }
        int res =0;
        for(int i: worker){
            res += ans[i];
        }
        return res;
    }
}