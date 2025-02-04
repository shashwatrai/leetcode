class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        int n = security.length;
        int prev[] = new int[n];
        int after[] = new int[n];
        Arrays.fill(prev,1);
        Arrays.fill(after,1);
        for(int i=1;i<n;i++){
            if(security[i] <= security[i-1]){
                prev[i] += prev[i-1];
            }
            if(security[n-1-i] <= security[n-i])
                after[n-1-i] += after[n-i];
        }

        List<Integer> res = new ArrayList<>();
        // System.out.println(Arrays.toString(prev));
        // System.out.println(Arrays.toString(after));
        for(int i=0;i<n;i++){
            if(Math.min(prev[i],after[i]) >= time+1)
                res.add(i);
        }
        return res;
    }
}