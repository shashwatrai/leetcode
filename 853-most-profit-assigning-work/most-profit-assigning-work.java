class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int  n =difficulty.length;

        Integer arr[] = new Integer[n];
        for(int i=0;i<n;i++)
            arr[i] = i;

        Arrays.sort(arr, (a,b)-> difficulty[a] != difficulty[b] 
                                    ? difficulty[a]-difficulty[b]:a-b);

        int maxProfit[] = new int[n];

        // int max = 0;
        // for(int i=0;i<n;i++){
        //     max = Math.max(max,profit[arr[i]]);
        //     maxProfit[i] = max;
        // }
        // System.out.println(Arrays.toString(arr)+" \n"+Arrays.toString(maxProfit));
        Arrays.sort(worker);
        int res=0;
        int max =0 ;
        int indx =0;
        // Arrays.sort(difficulty);
        // System.out.println(Arrays.toString(difficulty)+" \n"+Arrays.toString(arr)+"\n"+Arrays.toString(maxProfit));
        for(int i=0;i<worker.length;i++){
            while(indx < arr.length && worker[i] >= difficulty[arr[indx]]){
                max = Math.max(max,profit[arr[indx]]);
                indx++;
            }
            System.out.println(worker[i]+" "+indx+" "+max);
            res += max;
        }
        return res;
    }
}