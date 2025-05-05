class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int  n =difficulty.length;

        Integer arr[] = new Integer[n];
        for(int i=0;i<n;i++)
            arr[i] = i;

        Arrays.sort(arr, (a,b)-> difficulty[a] != difficulty[b] 
                                    ? difficulty[a]-difficulty[b]:a-b);

        Arrays.sort(worker);
        int res=0;
        int max =0 ;
        int indx =0;

        for(int i=0;i<worker.length;i++){
            while(indx < arr.length && worker[i] >= difficulty[arr[indx]]){
                max = Math.max(max,profit[arr[indx]]);
                indx++;
            }
            res += max;
        }
        return res;
    }
}